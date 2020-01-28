package human_resources;

import infrastructure.lhc.detector.IRODetector;

import java.util.ArrayList;

public class Researcher extends Employee {
    private boolean isSenior;

    private ArrayList<ResearchGroup> researchGroups;
    private IRODetector detector;

    public Researcher(int id, String name) {
        super(id, name);
        this.researchGroups = new ArrayList<>();
    }

    public IRODetector getDetector() {
        return detector;
    }

    public void setDetector(IRODetector detector) {
        this.detector = detector;
    }
}

