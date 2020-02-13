package main.infrastructure;

import main.human_resources.IResearchGroup;

public interface IWorkplace {
    void setResearchGroup(IResearchGroup researchGroup);
    IResearchGroup getResearchGroup();
}
