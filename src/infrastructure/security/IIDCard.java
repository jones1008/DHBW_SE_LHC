package infrastructure.security;

import human_resources.Person;

import java.util.ArrayList;
import java.util.Date;

public interface IIDCard extends IROIDCard {
    public void setValidFrom(Date validFrom);
    public void setValidUntil(Date validUntil);
    public void setIrisStructure(int[][] irisStructure);
    public void setIsLocked(boolean isLocked);
    public void setPermissionList(ArrayList<Permission> permissionList);
    public void setPassword(String password);
    public void setPerson(Person person);
    public String getId();
}
