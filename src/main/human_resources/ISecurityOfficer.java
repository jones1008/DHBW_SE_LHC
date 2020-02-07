package main.human_resources;

import main.infrastructure.security.ISecurityCentre;

public interface ISecurityOfficer {
    public void createIDCard(Employee employee, EmployeeType employeeType);
    public void setSecurityCentre(ISecurityCentre securityCentre);
}
