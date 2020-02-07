package main.human_resources;

import main.infrastructure.security.IDCard;
import main.infrastructure.security.IIDCard;
import main.infrastructure.security.Writer;

public interface IReception {
    public void setReceptionStaff(IReceptionStaff receptionStaff);
    public IReceptionStaff getReceptionStaff();
    public IDCard getFirstIDCard();
    public Writer getWriter();
    public void addVisitorIDCard(IIDCard idCard);
}
