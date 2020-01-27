package infrastructure.lhc;

import java.util.Date;
import java.util.UUID;

public class Experiment {
    private UUID uuid;
    private String dateTimeStamp;
    private boolean isHiggsBosonFound;

    private Block[] blocks;

    public Experiment() {
        this.blocks = new Block[200000];
        for (int i = 0; i < 200000; i++) {
            this.blocks[i] = new Block();
        }
        this.dateTimeStamp = new Date().toString();
        this.uuid = UUID.randomUUID();
    }

    @Override
    public String toString() {
        return uuid + ": " + dateTimeStamp + ", higgsBosonFound: " + isHiggsBosonFound;
    }
}
