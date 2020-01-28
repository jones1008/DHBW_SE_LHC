package infrastructure.security;

import human_resources.Employee;

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
        currentIDCard = idCard;
    }

    public void removeIDCard() {
        currentIDCard = null;
    }

    public boolean verifyPassword(String input) {
        CryptoEngine cryptoEngine = new AESCryptoEngine();
        input = cryptoEngine.encrypt(input);
        if (currentIDCard instanceof VisitorIDCard) {
            VisitorIDCard idCard = (VisitorIDCard) currentIDCard;
            return idCard.getCommunication().getData().equals(input);
        } else if (currentIDCard instanceof EmployeeIDCard) {
            EmployeeIDCard idCard = (EmployeeIDCard) currentIDCard;
            return idCard.getCommunication().getData().equals(input);
        }
        return false;
    }
}
