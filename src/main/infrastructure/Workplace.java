package main.infrastructure;

import main.human_resources.IResearchGroup;
import main.human_resources.Visitor;

public class Workplace implements IWorkplace{

    private IResearchGroup researchGroup;
    private IControlCenter controlCenter;
    private Visitor visitor;

    public Workplace() {
        this.controlCenter = ControlCenter.instance;
    }

    public void setResearchGroup(IResearchGroup researchGroup) {
        this.researchGroup = researchGroup;
    }

    public IResearchGroup getResearchGroup() {
        return this.researchGroup;
    }

    public void setVisitor(Visitor visitor) {
        this.visitor = visitor;
    }
}
