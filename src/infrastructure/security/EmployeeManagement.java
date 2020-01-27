package infrastructure.security;

import human_resources.Employee;
import human_resources.Researcher;
import human_resources.ScientificAssistant;
import human_resources.SecurityOfficer;

import java.util.HashMap;

public enum EmployeeManagement implements IEmployeeManagement {
    instance;
    private HashMap<Integer, Employee> employeeMap;
    private int employeeID;

    public void createEmployee(String name, String type) throws Exception {
        Employee employee;
        switch (type) {
            case "SecurityOfficer":
                employee = new SecurityOfficer(employeeID, name);
                break;
            case "Researcher":
                employee = new Researcher(employeeID, name);
                break;
            case "ScientificAssistant":
                employee = new ScientificAssistant(employeeID, name);
                break;
            default:
                throw new Exception("Employee type '"+ type + "' not supported");
        }

        employeeMap.put(employeeID, employee);
        employeeID++;
    }

    public void assignIDCard(IIDCard idCard, Employee employee) {

    }

    public void viewEmployeeData() {
        employeeMap.forEach((k, v) -> {
            System.out.println(v);
        });
    }

    EmployeeManagement() {
        this.employeeMap = new HashMap<>();
    }
}
