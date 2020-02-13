package main.human_resources;

public abstract class Employee extends Person{
    protected boolean isManager;
    protected boolean isMentor;
    protected boolean hasBudgetResponsibility;

    public Employee(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        String ret = Integer.toString(id) + ", '" + name + "', '";

        for (int i = 0; i < iris.length; i++) {
            for (int j = 0; j < iris[i].length; j++) {
                ret += Integer.toString(iris[i][j]);
            }
        }

        ret += "', " + this.getIdCard().getId();
        ret += fingerprint + "'";
        return ret;
    }
}

