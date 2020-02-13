package main.human_resources;

import main.infrastructure.security.IEmployeeManagement;

public class HRConsultant extends Employee {
    private IEmployeeManagement employeeManagement;

    public HRConsultant(int id, String name) {
        super(id, name);
    }
}
