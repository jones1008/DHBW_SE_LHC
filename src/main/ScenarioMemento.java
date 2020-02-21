package main;

import java.util.UUID;

public class ScenarioMemento {
    private UUID uuid;
    private int numberOfExperiments;
    private int initialEnergy;

    public ScenarioMemento(UUID uuid, int numberOfExperiments, int initialEnergy) {
        this.uuid = uuid;
        this.numberOfExperiments = numberOfExperiments;
        this.initialEnergy = initialEnergy;
    }

    public UUID getUuid() {
        return uuid;
    }

    public int getNumberOfExperiments() {
        return numberOfExperiments;
    }

    public int getInitialEnergy() {
        return initialEnergy;
    }
}
