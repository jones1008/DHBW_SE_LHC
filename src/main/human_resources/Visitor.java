package main.human_resources;

public class Visitor extends Person {

    public Visitor(int id, String name) {
        super(id, name);
    }

    public String getName() {
        return name;
    }
}
