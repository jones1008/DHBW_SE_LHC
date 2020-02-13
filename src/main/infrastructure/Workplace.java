package main.infrastructure;

import main.human_resources.IResearchGroup;

public class Workplace implements IWorkplace{

    private IResearchGroup researchGroup;
    private IControlCenter controlCenter;

    public Workplace() {
        this.controlCenter = ControlCenter.instance;
    }

    public void setResearchGroup(IResearchGroup researchGroup) {
        this.researchGroup = researchGroup;
    }

    public IResearchGroup getResearchGroup() {
        return this.researchGroup;
    }
}
