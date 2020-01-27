package infrastructure.security;

import human_resources.Employee;
import human_resources.ISecurityOfficer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public enum SecurityCenter implements ISecurityCentre {
    instance;
    private IIDCardManagement idCardManagement;
    private IROEmployeeManagement employeeManagement;

    private ISecurityOfficer securityOfficer;
    private Stack<IDCard> blankIDCards;
    private Writer writer;

    SecurityCenter() {
        writer = new Writer();
        blankIDCards = new Stack<>();
        for (int i = 100; i < 115; i++) {
            blankIDCards.add(new VisitorIDCard(Integer.toString(i)));
        }
        idCardManagement = IDCardManagement.instance;
    }

    public void addEmployeeIDCard(IIDCard idCard) {
        idCardManagement.addIDCard(idCard);
    }

    public void lockEmployeeIDCard(Employee employee) {
        idCardManagement.lockIDCard(employee);
    }


    public void setSecurityOfficer(ISecurityOfficer securityOfficer) {
        this.securityOfficer = securityOfficer;
        securityOfficer.setSecurityCentre(this);
    }

    public ISecurityOfficer getSecurityOfficer() {
        return securityOfficer;
    }

    public IDCard getFirstIDCard() {
        return blankIDCards.pop();
    }

    public Writer getWriter() {
        return writer;
    }
}
