package main.infrastructure;

import main.infrastructure.lhc.LargeHadronCollider;

public class Building {
    private String owner;
    private String location;

    private LargeHadronCollider lhc;

    public Building() {
        this.owner = "CERN";
        this.location = "Geneva";
    }
}
