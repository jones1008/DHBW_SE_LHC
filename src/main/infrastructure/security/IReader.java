package main.infrastructure.security;

import main.human_resources.Employee;

public interface IReader {
    // auskommentiert, weil Klasse Passport entfernt
//    public String scanPassport(Passport passport);

    public String scanIris(Employee employee);
    public void insertIDCard(IIDCard idCard);
    public void removeIDCard();
    public boolean verifyPassword(String input);
    IIDCard getCurrentIdCard();
}
