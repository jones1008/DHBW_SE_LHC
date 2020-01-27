package infrastructure.security;

import human_resources.Person;

import java.util.ArrayList;
import java.util.Date;

public abstract class IDCard implements IRFID, IIDCard {
    private String id;
    private Date validFrom;
    private Date validUntil;
    private int[][] irisStructure;
    private ArrayList<Permission> permissionList;
    private boolean isLocked;

    private Person person;

    public IDCard(String id) {
        this.id = id;
        this.irisStructure = new int[10][10];
    }

    public abstract String getData();

    public String getId() {
        return id;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public void setIrisStructure(int[][] irisStructure) {
        this.irisStructure = irisStructure;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public void setPermissionList(ArrayList<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
}

