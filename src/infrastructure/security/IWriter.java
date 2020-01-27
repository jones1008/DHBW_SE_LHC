package infrastructure.security;

import java.util.ArrayList;
import java.util.Date;

public interface IWriter {
    public void setIDCard(IIDCard idCard);
    public void setValidFrom(Date validFrom);
    public void setValidUntil(Date validUntil);
    public void setIrisStructure(int[][] irisStructure);
    public void setIsLocked(boolean isLocked);
    public void setPermissionList(ArrayList<Permission> permissionList);
    public void setPassword(String password);
}
