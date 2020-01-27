package infrastructure.security;

import human_resources.Employee;

public class Reader implements IReader {
    private String currentEmployeeIris;

    private IIDCardManagement idCardManagement;

    // auskommentiert, weil Klasse Passport entfernt
//    public String scanPassport(Passport passport) {
//        return "";
//    }

    public String scanIris(Employee employee) {
        return "";
    }

    public void insertIDCard(IDCard idCard) {

    }

    public void removeIDCard() {

    }
}
