package main.human_resources;

import main.infrastructure.security.IIDCard;
import main.infrastructure.security.MD5HashEngine;

import java.util.Random;

public abstract class Person implements IPerson {
    protected int id;
    protected String name;
    protected int[][] iris;
    protected String fingerprint;

    private IIDCard idCard;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
        this.iris = new int[10][10];
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                this.iris[i][j] = random.nextInt();
            }
        }

        MD5HashEngine engine = new MD5HashEngine();
        this.fingerprint = engine.hash(this.name);
    }

    public void setIdCard(IIDCard idCard) {
        this.idCard = idCard;
        idCard.setPerson(this);
    }

    public String enterPassword() {
        // TODO: von Konsole einlesen
        return "12345";
    }

    public IIDCard getIdCard() {
        return idCard;
    }

    public String getName() {
        return this.name;
    }

    public int[][] getIris() {
        return this.iris;
    }

    @Override
    public String toString() {
        return id + ": " + name;
    }

    public int getId() {
        return this.id;
    }
}

