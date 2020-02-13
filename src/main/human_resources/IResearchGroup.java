package main.human_resources;

import main.infrastructure.IWorkplace;

import java.util.List;

public interface IResearchGroup {
    void setWorkplace(IWorkplace workplace);
    IWorkplace workplace();
    List<Researcher> getResearchers();
}
