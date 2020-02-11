package main.infrastructure.lhc.experiment;

import main.infrastructure.lhc.Block;
import main.infrastructure.lhc.IBlock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Experiment implements IExperiment {
    private UUID uuid;
    private String dateTimeStamp;
    private boolean isHiggsBosonFound;

    private IBlock[] blocks;
    private int[] protonIDs;

    public Experiment() {
        this.blocks = new Block[200000];
        for (int i = 0; i < 200000; i++) {
            this.blocks[i] = new Block();
        }
        this.dateTimeStamp = new Date().toString();
        this.uuid = UUID.randomUUID();

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

        dateTimeStamp = dateFormat.format(new Date());
    }

    public IBlock getBlock(int i) {
        return blocks[i];
    }

    public void setHiggsBosonFound() {
        this.isHiggsBosonFound = true;
    }

    public boolean getHiggsBosonFound() {
        return this.isHiggsBosonFound;
    }

    @Override
    public String toString() {
        return uuid + ": " + dateTimeStamp + ", higgsBosonFound:" + isHiggsBosonFound + ", Proton1:" + protonIDs[0] +
                " Proton2:" + protonIDs[1];
    }

    public void setProtonIDs(int id1, int id2) {
        this.protonIDs = new int[]{id1, id2};
    }
}
