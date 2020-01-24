package infrastructure.security;

import human_resources.Employee;

import java.util.HashMap;

public enum IDCardManagement implements IIDCardManagement {
    instance;
    private HashMap<Integer, IDCard> idCardHashMap;

    private Reader reader;

    public void lockIDCard(IDCard idCard) {

    }

    public void clearIDCard(IDCard idCard) {

    }

    IDCardManagement() {
        this.idCardHashMap = new HashMap<>();
    }
}
