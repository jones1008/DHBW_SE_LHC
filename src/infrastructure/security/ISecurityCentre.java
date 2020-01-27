package infrastructure.security;

import human_resources.Employee;
import human_resources.ISecurityOfficer;

public interface ISecurityCentre {
    public void addEmployeeIDCard(IIDCard idCard);
    public void lockEmployeeIDCard(Employee employee);
    public void setSecurityOfficer(ISecurityOfficer securityOfficer);
    public ISecurityOfficer getSecurityOfficer();
    public IDCard getFirstIDCard();
    public Writer getWriter();
}
