package main.infrastructure.security;

import main.human_resources.Employee;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public enum IDCardManagement implements IIDCardManagement {
    instance;
    private HashMap<Integer, IIDCard> idCardHashMap;

    private Reader reader;

    public void lockIDCard(Employee employee) {
        idCardHashMap.forEach((k, v) ->{
            if (v.getPerson().equals(employee)) {
                v.setIsLocked(true);
            }
        });
    }

    public void clearIDCard(IIDCard idCard) {

    }

    public void addIDCard(IIDCard idCard) {
        idCardHashMap.put(Integer.parseInt(idCard.getId()), idCard);
    }

    IDCardManagement() {
        this.idCardHashMap = new HashMap<>();
    }
}
