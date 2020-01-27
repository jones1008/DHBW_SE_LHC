package human_resources;

import infrastructure.security.EmployeeManagement;
import infrastructure.security.IROEmployeeManagement;

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
