public abstract class Person {
    protected int id;
    protected String name;
    protected int[][] iris;

    private Passport passport;
    private IDCard idCard;

    public Person() {
        this.iris = new int[10][10];
    }
}

