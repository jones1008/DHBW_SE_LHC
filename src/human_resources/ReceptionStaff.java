package human_resources;

import infrastructure.security.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class ReceptionStaff extends Employee implements IReceptionStaff {
    private IDCard currentIDCard;
    private Visitor currentVisitor;
    private IReception reception;

    public ReceptionStaff(int id, String name) {
        super(id, name);
    }

    public void createIDCard(Visitor visitor) {
        currentVisitor = visitor;
        currentIDCard = reception.getFirstIDCard();

        IWriter writer = reception.getWriter();
        writer.setIDCard(currentIDCard);
        writer.setIrisStructure(visitor.iris);
        writer.setIsLocked(false);

        ArrayList<Permission> permissionList = new ArrayList<>();
        permissionList.add(Permission.VISITOR);
        writer.setPermissionList(permissionList);

        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        writer.setValidFrom(today);
        writer.setValidUntil(tomorrow);

        writer.setPassword(visitor.enterPassword());

        reception.addVisitorIDCard(currentIDCard);

        this.giveIDCard();
    }

    private void giveIDCard() {
        currentVisitor.setIdCard(currentIDCard);
        currentIDCard = null;
        currentVisitor = null;
    }

    public void setReception(IReception reception) {
        this.reception = reception;
    }
}
