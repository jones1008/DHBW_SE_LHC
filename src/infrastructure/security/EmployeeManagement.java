package infrastructure.security;

import human_resources.Employee;

import java.util.HashMap;

public enum EmployeeManagement implements IEmployeeManagement {
    instance;
    private HashMap<Integer, Employee> employeeMap;

    public void createEmployee(String name, String type) {

    }

    public void assignIDCard(IDCard idCard, Employee employee) {

    }

    public void vieEmployeeData() {

    }

    EmployeeManagement() {
        this.employeeMap = new HashMap<>();
    }
}
