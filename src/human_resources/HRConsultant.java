package human_resources;

import infrastructure.security.IEmployeeManagement;

public class HRConsultant extends Employee {
    private IEmployeeManagement employeeManagement;

    public HRConsultant(int id, String name) {
        super(id, name);
    }
}
