package infrastructure.security;

import human_resources.Employee;

public interface IReader {
    // auskommentiert, weil Klasse Passport entfernt
//    public String scanPassport(Passport passport);

    public String scanIris(Employee employee);

    public void insertIDCard(IDCard idCard);

    public void removeIDCard();
}
