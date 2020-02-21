package main.human_resources;

import main.infrastructure.IWorkplace;
import main.infrastructure.Workplace;

import java.util.ArrayList;
import java.util.List;

public class ResearchGroup implements IResearchGroup {

    private List<ScientificAssistant> scientificAssistants;
    private List<Researcher> researchers;
    private IWorkplace workplace;

    public ResearchGroup(Researcher researcher) {
        this.researchers = new ArrayList<>();
        this.scientificAssistants = new ArrayList<>();

        this.researchers.add(researcher);
    }

    public void setWorkplace(IWorkplace workplace) {
        this.workplace = workplace;
    }

    public IWorkplace workplace() {
        return this.workplace;
    }

    public List<Researcher> getResearchers() {
        return this.researchers;
    }

    public void setScientificAssistants(List<ScientificAssistant> scientificAssistants) {
        this.scientificAssistants = scientificAssistants;
    }
}
