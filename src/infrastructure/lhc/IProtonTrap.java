package infrastructure.lhc;

public interface IProtonTrap {
    public void loadData(String dataFilePath, int id);
    public Proton release();
}
