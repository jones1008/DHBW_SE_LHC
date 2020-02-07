package main.human_resources;

import main.infrastructure.security.EmployeeManagement;
import main.infrastructure.security.IROEmployeeManagement;

public class HRAssistant extends Employee {
    private IROEmployeeManagement employeeManagement;

    public HRAssistant(int id, String name) {
        super(id, name);
        this.employeeManagement = EmployeeManagement.instance;
    }

    public IROEmployeeManagement getEmployeeManagement() {
        return employeeManagement;
    }
}
