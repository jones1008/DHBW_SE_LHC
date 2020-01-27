package infrastructure.security;

import human_resources.Employee;

public interface IEmployeeManagement extends IROEmployeeManagement{
    public void createEmployee(String name, String type);

    public void assignIDCard(IDCard idCard, Employee employee);
}
