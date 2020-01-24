package infrastructure.security;

import human_resources.Employee;

public interface IIDCardManagement {
    public void lockIDCard(IDCard idCard);

    public void clearIDCard(IDCard idCard);
}
