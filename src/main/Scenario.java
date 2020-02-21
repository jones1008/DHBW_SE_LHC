package main;

import java.util.UUID;

public class Scenario {
    private UUID uuid;
    private int numberOfExperiments;
    private int initialEnergy;

    public Scenario(int numberOfExperiments, int initialEnergy) {
        this.uuid = UUID.randomUUID();
        this.numberOfExperiments = numberOfExperiments;
        this.initialEnergy = initialEnergy;
    }

    public int getNumberOfExperiments() {
        return numberOfExperiments;
    }

    public int getInitialEnergy() {
        return initialEnergy;
    }

    public ScenarioMemento save() {
        return new ScenarioMemento(uuid, numberOfExperiments, initialEnergy);
    }

    public void setNumberOfExperiments(int numberOfExperiments) {
        this.numberOfExperiments = numberOfExperiments;
    }

    public void setInitialEnergy(int initialEnergy) {
        this.initialEnergy = initialEnergy;
    }

    public void restore(ScenarioMemento memento) {
        uuid = memento.getUuid();
        numberOfExperiments = memento.getNumberOfExperiments();
        initialEnergy = memento.getInitialEnergy();
    }

    @Override
    public String toString() {
        return "[Scenario " + uuid + "] #Experiments: " + numberOfExperiments + ", initialEnergy: " + initialEnergy;
    }
}
