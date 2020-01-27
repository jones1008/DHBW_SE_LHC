package human_resources;

import infrastructure.security.IDCard;
import infrastructure.security.IIDCard;
import infrastructure.security.Writer;

public interface IReception {
    public void setReceptionStaff(IReceptionStaff receptionStaff);
    public IReceptionStaff getReceptionStaff();
    public IDCard getFirstIDCard();
    public Writer getWriter();
    public void addVisitorIDCard(IIDCard idCard);
}
