package infrastructure.lhc;

import infrastructure.security.Reader;

import java.util.LinkedList;

public class Detector implements IRODetector {
    private static String higgsBosonStructure = "higgs";
    private boolean isActivated;

    private LinkedList<Experiment> experimentList;
    private Reader reader;
    private Ring ring;

    public Detector() {
        this.experimentList = new LinkedList<>();
    }

    public void addExperiment(Experiment experiment) {
        experimentList.add(experiment);
    }

    public void viewExperiments() {
        for (Experiment experiment : experimentList) {
            System.out.println(experiment);
        }
    }
}

