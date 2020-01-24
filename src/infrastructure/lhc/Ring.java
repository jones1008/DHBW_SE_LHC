package infrastructure.lhc;

public class Ring implements IRing{
    private boolean isActivated;
    private int energy;

    private Experiment currentExperiment;
    private LargeHadronCollider lhc;
    private Magnet[] magnets;
    private Detector detector;
    private ProtonTrap[] protonTraps;

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
        this.magnets = new Magnet[72];
        for (int i = 0; i < 72; i++) {
            this.magnets[i] = new Magnet();
        }
    }
}
