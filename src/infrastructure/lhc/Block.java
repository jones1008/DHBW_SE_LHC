package infrastructure.lhc;

import java.util.UUID;

public class Block implements IBlock {
    private UUID uuid;
    private String structure;

    public String getStructure() {
        return structure;
    }
}

