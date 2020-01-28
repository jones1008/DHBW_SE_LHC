package infrastructure.lhc;

import com.google.common.eventbus.Subscribe;
import infrastructure.lhc.detector.Detector;
import infrastructure.lhc.experiment.Experiment;
import infrastructure.lhc.experiment.RunExperimentFullEvent;
import infrastructure.lhc.experiment.RunExperimentPartialEvent;

public class Ring extends Subscriber implements IRing {
    private boolean isActivated;
    private int energy;

    private Experiment currentExperiment;
    private LargeHadronCollider lhc;
    private Magnet[] magnets;
    private Detector detector;
    private ProtonTrap[] protonTraps;

    private Proton proton01;
    private Proton proton02;

    public void activate() {

    }

    public void activate(int initialEnergy) {

    }

    public void activateMagneticField() {

    }

    public void releaseProton() {

    }

    public void increaseEnergy(int delta) {

    }

    public void collide(Proton proton01, Proton proton02) {

    }

    public int decreaseEnergy() {
        return 0;
    }

    public void shutdown() {

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
        activate(event.getInitialEnergy());
        activateMagneticField();
        releaseProton();
        while (energy < 300000) {
            increaseEnergy(25000);
        }
    }

    @Subscribe
    public void receive(RunExperimentPartialEvent event) {

    }
}
