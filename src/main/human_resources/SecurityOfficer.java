package main.human_resources;

import main.infrastructure.security.IIDCard;
import main.infrastructure.security.ISecurityCentre;
import main.infrastructure.security.IWriter;
import main.infrastructure.security.Permission;

import java.util.ArrayList;
import java.util.Date;

public class SecurityOfficer extends Employee implements ISecurityOfficer {
    private boolean hasWeapon;
    private ISecurityCentre securityCentre;

    private IIDCard currentIDCard;

    public SecurityOfficer(int id, String name) {
        super(id, name);
    }

    public void createIDCard(Employee employee, EmployeeType employeeType) {
        currentIDCard = securityCentre.getFirstIDCard();

        IWriter writer = securityCentre.getWriter();
        writer.setIDCard(currentIDCard);
        writer.setIrisStructure(employee.iris);
        writer.setIsLocked(false);

        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 365));
        writer.setValidFrom(today);
        writer.setValidUntil(tomorrow);

        ArrayList<Permission> permissions = new ArrayList<>();
        switch (employeeType) {
            case Researcher:
                permissions.add(Permission.RESEARCHER);
                permissions.add(Permission.CONTROLCENTER);
                break;
            case ScientificAssitant:
                permissions.add(Permission.CONTROLCENTER);
                break;
            case SecurityOfficer:
                permissions.add(Permission.CONTROLCENTER);
                permissions.add(Permission.SECURITY);
                break;
        }
        writer.setPermissionList(permissions);

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

