package main.infrastructure.lhc.experiment;

import main.infrastructure.lhc.IBlock;

import java.util.List;

public interface IExperiment {
    void setHiggsBosonFound();
    boolean getHiggsBosonFound();
    IBlock getBlock(int i);
    void setProtonIDs(int id1, int id2);
    String toDatabaseString();
    String getUuid();
    void addBlock(IBlock block);
    List<IBlock> getBlocks();
}
