package main.infrastructure.security;

import main.human_resources.Employee;
import main.human_resources.ISecurityOfficer;

public interface ISecurityCentre {
    public void addEmployeeIDCard(IIDCard idCard);
    public void lockEmployeeIDCard(Employee employee);
    public void setSecurityOfficer(ISecurityOfficer securityOfficer);
    public ISecurityOfficer getSecurityOfficer();
    public IIDCard getFirstIDCard();
    public Writer getWriter();
}
