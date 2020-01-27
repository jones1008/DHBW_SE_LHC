package human_resources;

import infrastructure.security.IEmployeeManagement;

public class HRHoD extends Employee {
    private IEmployeeManagement employeeManagement;

    public HRHoD(int id, String name) {
        super(id, name);
    }
}
