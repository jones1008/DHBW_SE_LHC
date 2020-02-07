package main.infrastructure.lhc.experiment;

import main.infrastructure.lhc.IBlock;

public interface IExperiment {
    public void setHiggsBosonFound();
    public IBlock getBlock(int i);
    public void setProtonIDs(int id1, int id2);
}
