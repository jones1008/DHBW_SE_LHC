package main.infrastructure.security;

import main.human_resources.Employee;

import java.util.Date;

public class Reader implements IReader {
    private String currentEmployeeIris;

    private IIDCardManagement idCardManagement;
    private IIDCard currentIDCard;

    // auskommentiert, weil Klasse Passport entfernt
//    public String scanPassport(Passport passport) {
//        return "";
//    }

    public Reader() {
        idCardManagement = IDCardManagement.instance;
    }

    public String scanIris(Employee employee) {
        return "";
    }

    public void insertIDCard(IIDCard idCard) {
        if (idCard.getIsLocked() ||
            idCard.getValidUntil().compareTo(new Date()) < 0) {
            System.out.println("Card was denied.");
            return;
        }
        currentIDCard = idCard;
    }

    public void removeIDCard() {
        currentIDCard = null;
    }

    public boolean verifyPassword(String input) {
        if (currentIDCard.getIsLocked())
            return false;

        CryptoEngine cryptoEngine = new AESCryptoEngine();
        input = cryptoEngine.encrypt(input);
        boolean res = false;
        if (currentIDCard instanceof VisitorIDCard) {
            VisitorIDCard idCard = (VisitorIDCard) currentIDCard;
            res = idCard.getCommunication().getData().equals(input);
        } else if (currentIDCard instanceof EmployeeIDCard) {
            EmployeeIDCard idCard = (EmployeeIDCard) currentIDCard;
            res = idCard.getCommunication().getData().equals(input);
        }

        if (res) {
            currentIDCard.resetInvalidPwdCounter();
        } else {
            currentIDCard.increaseInvalidPwdCounter();
            if (currentIDCard.getInvalidPwdCounter() >= 3) {
                currentIDCard.setIsLocked(true);
            }
        }

        return res;
    }

    public IIDCard getCurrentIdCard() {
        return this.currentIDCard;
    }
}
