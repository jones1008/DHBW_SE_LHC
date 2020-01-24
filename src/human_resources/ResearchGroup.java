package human_resources;

import infrastructure.Workplace;

import java.util.ArrayList;

public class ResearchGroup {

    private ArrayList<ScientificAssistant> scientificAssistants;
    private ArrayList<Researcher> researchers;
    private Workplace workplace;

    public ResearchGroup(Researcher researcher) {
        this.researchers = new ArrayList<>();
        this.scientificAssistants = new ArrayList<>();

        this.researchers.add(researcher);
    }
}
