package main;// Training Entwurfsmuster LHC: Aufgabe 9

import java.util.TreeMap;

public enum ScenarioManager {
    instance;
    private TreeMap<Integer, Scenario> scenarios;
    private int id = 0;

    ScenarioManager() {
        scenarios = new TreeMap<>();
    }

    public void addScenario(int numberOfExperiments, int initialEnergy) {
        scenarios.put(id++, new Scenario(numberOfExperiments, initialEnergy));
    }

    public TreeMap<Integer, Scenario> getScenarios() {
        return scenarios;
    }

    public Scenario getScenario(int index) {
        return scenarios.get(index);
    }
}
