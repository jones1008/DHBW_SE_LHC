package main.infrastructure.lhc;

import com.google.common.eventbus.Subscribe;
import main.infrastructure.lhc.detector.IDetector;
import main.infrastructure.lhc.experiment.Experiment;
import main.infrastructure.lhc.experiment.RunExperimentFullEvent;
import main.infrastructure.lhc.experiment.RunExperimentPartialEvent;

public class Ring extends Subscriber implements IRing {
    private boolean isActivated;
    private int energy;

    private Experiment currentExperiment;
    private LargeHadronCollider lhc;
    private Magnet[] magnets;
    private IDetector detector;
    private IProtonTrap protonTrap01;
    private IProtonTrap protonTrap02;

    private Proton currentProton01;
    private Proton currentProton02;

    public void activate() {
        this.activate(25000);
    }

    public void activate(int initialEnergy) {
        this.energy = initialEnergy;
        this.isActivated = true;
        this.currentExperiment = new Experiment();
    }

    public void activateMagneticField() {
        for (int i = 0; i < magnets.length; i++) {
            magnets[i].activate();
        }
    }

    public void releaseProton() {
        currentProton01 = protonTrap01.release();
        currentProton02 = protonTrap02.release();
    }

    public void increaseEnergy(int delta) {
        this.energy += delta;
    }

    public void collide() {

        currentExperiment.setProtonIDs(currentProton01.getId(), currentProton02.getId());

        int[][][] structure01 = currentProton01.getStructure();
        String content01 = structureToString(structure01);

        int[][][] structure02 = currentProton02.getStructure();
        String content02 = structureToString(structure02);

        for (int i = 0; i < 200000; i++) {
            String substring01 = content01.substring(i*5, i*5+5);
            String substring02 = content02.substring(i*5, i*5+5);

            currentExperiment.getBlock(i).setStructure(substring01 + substring02);
        }

        currentProton01 = null;
        currentProton02 = null;
    }

    private String structureToString(int[][][] structure) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < structure.length; i++) {
            for (int j = 0; j < structure[i].length; j++) {
                for (int k = 0; k < structure[j].length; k++) {
                    ret.append((char) structure[i][j][k]);
                }
            }
        }
        return ret.toString();
    }

    public int decreaseEnergy() {
        this.energy = 0;
        return this.energy;
    }

    public void shutdown() {
        detector.addExperiment(currentExperiment);
        currentExperiment = null;

        this.decreaseEnergy();

        for (Magnet magnet : magnets) {
            magnet.deactivate();
        }

        this.isActivated = false;
    }

    public Ring() {
        super();
        this.magnets = new Magnet[72];
        for (int i = 0; i < 72; i++) {
            this.magnets[i] = new Magnet();
        }
    }

    @Subscribe
    public void receive(RunExperimentFullEvent event) {
        for (int i = 0; i < 25; i++) {
            executeExperiment(event.getInitialEnergy());
        }
    }

    @Subscribe
    public void receive(RunExperimentPartialEvent event) {
        int circulationNumber = 0;
        switch (event.getScope()) {
            case ES5:
                circulationNumber = 5;
                break;
            case ES10:
                circulationNumber = 10;
                break;
            case ES20:
                circulationNumber = 20;
                break;
            case ESFull:
                circulationNumber = 25;
                break;
        }
        for (int i = 0; i < circulationNumber; i++) {
            executeExperiment(event.getInitialEnergy());
        }
    }

    private void executeExperiment(int initialEnergy) {
        activate(initialEnergy);
        activateMagneticField();

        releaseProton();

        while (energy < 300000) {
            increaseEnergy(25000);
        }

        this.collide();
        this.shutdown();
    }

    public void setProtonTraps(IProtonTrap protonTrap01, IProtonTrap protonTrap02) {
        this.protonTrap01 = protonTrap01;
        this.protonTrap02 = protonTrap02;
    }

    public void setDetector(IDetector detector) {
        this.detector = detector;
    }
}
