package human_resources;

import infrastructure.security.IDCard;
import infrastructure.security.IIDCard;

import javax.xml.namespace.QName;
import java.util.Random;

public abstract class Person {
    protected int id;
    protected String name;
    protected int[][] iris;

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

    @Override
    public String toString() {
        return id + ": " + name;
    }
}

