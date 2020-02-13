package main.infrastructure.lhc.experiment;

public class RunExperimentPartialEvent {
    private int initialEnergy;
    private ExperimentScope scope;

    public RunExperimentPartialEvent(int initialEnergy, ExperimentScope scope) {
        if (initialEnergy != 25 && initialEnergy != 50 && initialEnergy != 100) {
            this.initialEnergy = 25000;
        } else {
            this.initialEnergy = 1000 * initialEnergy;
        }

        this.scope = scope;
    }

    public int getInitialEnergy() {
        return initialEnergy;
    }

    public ExperimentScope getScope() {
        return scope;
    }
}
