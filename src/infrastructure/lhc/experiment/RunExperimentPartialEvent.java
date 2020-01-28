package infrastructure.lhc.experiment;

public class RunExperimentPartialEvent {
    private int initialEnergy;

    public RunExperimentPartialEvent(int initialEnergy) {
        if (initialEnergy != 25 && initialEnergy != 50 && initialEnergy != 100) {
            this.initialEnergy = 25000;
        } else {
            this.initialEnergy = 1000 * initialEnergy;
        }
    }

    public int getInitialEnergy() {
        return initialEnergy;
    }
}
