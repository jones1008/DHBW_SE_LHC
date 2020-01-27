package infrastructure.security;

import java.util.ArrayList;
import java.util.Date;

public class Writer implements IWriter{
    private IIDCard idCard;
    private CryptoEngine cryptoEngine;

    public Writer() {
        cryptoEngine = new AESCryptoEngine();
    }

    public void setIDCard(IIDCard idCard) {
        this.idCard = idCard;
    }

    public void setValidFrom(Date validFrom) {
        idCard.setValidFrom(validFrom);
    }

    public void setValidUntil(Date validUntil) {
        idCard.setValidUntil(validUntil);
    }

    public void setIrisStructure(int[][] irisStructure) {
        idCard.setIrisStructure(irisStructure);
    }

    public void setIsLocked(boolean isLocked) {
        idCard.setIsLocked(isLocked);
    }

    public void setPermissionList(ArrayList<Permission> permissionList) {
        idCard.setPermissionList(permissionList);
    }

    public void setPassword(String password) {
        idCard.setPassword(cryptoEngine.encrypt(password));
    }
}
