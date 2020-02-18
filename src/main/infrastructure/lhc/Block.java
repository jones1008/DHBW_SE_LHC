package main.infrastructure.lhc;

import java.util.UUID;

public class Block implements IBlock {
    private UUID uuid;
    private String structure;

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public Block() {
        this.uuid = UUID.randomUUID();
    }

    public Block(String uuid, String structure) {
        this.uuid = UUID.fromString(uuid);
        this.structure = structure;
    }

    @Override
    public String toString() {
        return "'" + uuid.toString() + "', '" + structure + "'";
    }
}

