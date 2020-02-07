package main.human_resources;

import main.infrastructure.security.IIDCard;

public interface IPerson {
    String enterPassword();
    void setIdCard(IIDCard idCard);

    IIDCard getIdCard();
    String getName();
    int[][] getIris();
}
