package infrastructure.lhc;

public class Proton {
    private int id;
    private int[][][] structure;
    private double weight;

    private ProtonTrap protonTrap;

    public Proton(int id, int[][][] structure) {
        this.id = id;
        this.structure = structure;
    }

    public int[][][] getStructure() {
        return structure;
    }

    public int getId() {
        return id;
    }
}
