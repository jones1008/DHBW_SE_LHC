package main.infrastructure.security;

import main.human_resources.IPerson;
import main.human_resources.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class IDCard implements IIDCard {
    private String id;
    private Date validFrom;
    private Date validUntil;
    private int[][] irisStructure;
    private List<Permission> permissionList;
    private boolean isLocked;
    private int invalidPwdCounter;

    protected ICommunication communication;
    private IPerson person;

    public IDCard(String id) {
        this.id = id;
        this.irisStructure = new int[10][10];
        this.communication = new RFID();
        this.invalidPwdCounter = 0;
    }

    public String getId() {
        return id;
    }

    public boolean getIsLocked() {
        return this.isLocked;
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

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public IPerson getPerson() {
        return person;
    }

    public Date getValidFrom() {
        return this.validFrom;
    }

    public Date getValidUntil() {
        return this.validUntil;
    }

    public void setCommunication(ICommunication communication) {
        this.communication = communication;
    }

    public ICommunication getCommunication() {
        return this.communication;
    }

    public int[][] getIrisStructure() {
        return this.irisStructure;
    }

    public List<Permission> getPermissions() {
        return this.permissionList;
    }

    public void increaseInvalidPwdCounter() {
        this.invalidPwdCounter += 1;
    }

    public void resetInvalidPwdCounter() {
        this.invalidPwdCounter = 0;
    }

    public int getInvalidPwdCounter() {
        return this.invalidPwdCounter;
    }
}

