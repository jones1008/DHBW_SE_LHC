package infrastructure.security;

import human_resources.Employee;

public interface IReader {
    public String scanPassport(Passport passport);

    public String scanIris(Employee employee);

    public void insertIDCard(IDCard idCard);

    public void removeIDCard();
}
