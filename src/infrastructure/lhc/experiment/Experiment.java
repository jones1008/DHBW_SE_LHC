package infrastructure.lhc.experiment;

import infrastructure.lhc.Block;
import infrastructure.lhc.IBlock;

import java.util.Date;
import java.util.UUID;

public class Experiment implements IExperiment {
    private UUID uuid;
    private String dateTimeStamp;
    private boolean isHiggsBosonFound;

    private IBlock[] blocks;

    public Experiment() {
        this.blocks = new Block[200000];
        for (int i = 0; i < 200000; i++) {
            this.blocks[i] = new Block();
        }
        this.dateTimeStamp = new Date().toString();
        this.uuid = UUID.randomUUID();
    }

    public IBlock getBlock(int i) {
        return blocks[i];
    }

    public void setHiggsBosonFound() {
        this.isHiggsBosonFound = true;
    }

    @Override
    public String toString() {
        return uuid + ": " + dateTimeStamp + ", higgsBosonFound: " + isHiggsBosonFound;
    }
}
