package infrastructure.security;

import human_resources.Employee;

public interface IEmployeeManagement extends IROEmployeeManagement{
    public void createEmployee(String name, String type) throws Exception;

    public void assignIDCard(IIDCard idCard, Employee employee);
}
