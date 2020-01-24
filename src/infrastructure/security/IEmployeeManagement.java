package infrastructure.security;

import human_resources.Employee;

public interface IEmployeeManagement extends IROEmployeeManagement{
    public void createEmployee(String name);

    public void assignIDCard(IDCard idCard, Employee employee);
}
