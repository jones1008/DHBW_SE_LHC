package main.human_resources;

import main.infrastructure.security.*;

import java.util.Stack;

public enum Reception implements IReception {
    instance;

    private IReceptionStaff receptionStaff;
    private Stack<IDCard> blankIDCards;
    private IIDCardManagement idCardManagement;

    private Writer writer;

    Reception() {
        idCardManagement = IDCardManagement.instance;
        writer = new Writer();
        blankIDCards = new Stack<>();
        for (int i = 0; i < 15; i++) {
            blankIDCards.add(new VisitorIDCard(Integer.toString(i)));
        }
    }

    public void setReceptionStaff(IReceptionStaff receptionStaff) {
        this.receptionStaff = receptionStaff;
        receptionStaff.setReception(this);
    }

    public void addVisitorIDCard(IIDCard idCard) {
        idCardManagement.addIDCard(idCard);
    }

    public IReceptionStaff getReceptionStaff() {
        return receptionStaff;
    }

    public IDCard getFirstIDCard() {
        return blankIDCards.pop();
    }

    public Writer getWriter() {
        return writer;
    }
}
