package human_resources;

import infrastructure.security.IIDCard;
import infrastructure.security.ISecurityCentre;
import infrastructure.security.IWriter;
import infrastructure.security.Permission;

import java.util.ArrayList;
import java.util.Date;

public class SecurityOfficer extends Employee implements ISecurityOfficer {
    private boolean hasWeapon;
    private ISecurityCentre securityCentre;

    private IIDCard currentIDCard;

    public SecurityOfficer(int id, String name) {
        super(id, name);
    }

    public void createIDCard(Employee employee) {
        currentIDCard = securityCentre.getFirstIDCard();

        IWriter writer = securityCentre.getWriter();
        writer.setIDCard(currentIDCard);
        writer.setIrisStructure(employee.iris);
        writer.setIsLocked(false);

        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
        writer.setValidFrom(today);
        writer.setValidUntil(tomorrow);

        ArrayList<Permission> permissions = new ArrayList<>();
        // TODO: permission setzen
        writer.setPassword("helloLHC2020");

        // TODO: fingerprint setzen

        employee.setIdCard(currentIDCard);

        securityCentre.addEmployeeIDCard(currentIDCard);
        currentIDCard = null;
    }

    public void setSecurityCentre(ISecurityCentre securityCentre) {
        this.securityCentre = securityCentre;
    }
}

