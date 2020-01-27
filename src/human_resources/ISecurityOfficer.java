package human_resources;

import infrastructure.security.ISecurityCentre;

public interface ISecurityOfficer {
    public void createIDCard(Employee employee);
    public void setSecurityCentre(ISecurityCentre securityCentre);
}
