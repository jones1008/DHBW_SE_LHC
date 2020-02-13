package main.infrastructure.security;

import main.human_resources.IPerson;
import main.human_resources.Person;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IIDCard extends IROIDCard {
    public void setValidFrom(Date validFrom);
    public void setValidUntil(Date validUntil);
    public void setIrisStructure(int[][] irisStructure);
    public void setIsLocked(boolean isLocked);
    public void setPermissionList(List<Permission> permissionList);
    public void setPassword(String password);
    public void setPerson(Person person);
    public void setCommunication(ICommunication communication);
    public IPerson getPerson();
    public ICommunication getCommunication();
    Date getValidFrom();
    Date getValidUntil();
    int[][] getIrisStructure();
    List<Permission> getPermissions();
    void increaseInvalidPwdCounter();
    void resetInvalidPwdCounter();
    int getInvalidPwdCounter();
}
