package main.human_resources;

import main.ScenarioManager;

import java.util.ArrayList;
import java.util.Date;

public class ScientificAssistant extends Employee {
    private Date periodFrom;
    private Date periodUntil;

    private ArrayList<ResearchGroup> researchGroups;

    public ScientificAssistant(int id, String name) {
        super(id, name);
        this.researchGroups = new ArrayList<>();
    }

    public void createScenario(Researcher researcher, int numberOfExperiments, int initialEnergy) {
        ScenarioManager.instance.addScenario(numberOfExperiments, initialEnergy);
    }
}

