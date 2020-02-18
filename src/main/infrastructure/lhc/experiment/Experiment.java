package main.infrastructure.lhc.experiment;

import main.infrastructure.lhc.Block;
import main.infrastructure.lhc.IBlock;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Experiment implements IExperiment {
    private UUID uuid;
    private String dateTimeStamp;
    private boolean isHiggsBosonFound;

    private List<IBlock> blocks;
    private int[] protonIDs;

    public Experiment() {
        this.blocks = new ArrayList<>();
        for (int i = 0; i < 200000; i++) {
            blocks.add(i, new Block());
        }
        this.dateTimeStamp = new Date().toString();
        this.uuid = UUID.randomUUID();

        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

        dateTimeStamp = dateFormat.format(new Date());
    }

    public Experiment(String id, String dateTimeStamp, boolean isHiggsBosonFound, int proton01, int proton02) {
        this.uuid = UUID.fromString(id);
        this.dateTimeStamp = dateTimeStamp;
        this.isHiggsBosonFound = isHiggsBosonFound;
        setProtonIDs(proton01, proton02);
        this.blocks = new ArrayList<>();
    }

    public void addBlock(IBlock block) {
        this.blocks.add(block);
    }

    public IBlock getBlock(int i) {
        return blocks.get(i);
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

    public String toDatabaseString() {
        String ret = "'" + this.uuid.toString() + "', '" +
                dateTimeStamp + "', " +
                isHiggsBosonFound + ", " +
                protonIDs[0] + ", " +
                protonIDs[1];
        return ret;
    }

    public String getUuid() {
        return uuid.toString();
    }

    public List<IBlock> getBlocks() {
        return this.blocks;
    }

}
