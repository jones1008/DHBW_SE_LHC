package main.infrastructure.security;

import main.human_resources.Employee;

public interface IIDCardManagement {
    public void lockIDCard(Employee employee);
    public void clearIDCard(IIDCard idCard);
    public void addIDCard(IIDCard idCard);
}
