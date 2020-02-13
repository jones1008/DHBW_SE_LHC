package main.infrastructure.energy;

import main.infrastructure.lhc.LargeHadronCollider;

public class USP implements IUSP {
    private boolean isStandBy;
    private boolean isActivated;

    private LargeHadronCollider lhc;
    private Battery[] batteries;

    public void determineChargeState() {

    }

    public void charge(ThreePinPlug plug) {

    }

    public int takeOut() {
        return 0;
    }

    public Battery[] getBatteries() {
        return batteries;
    }

    public void setBatteries(Battery[] batteries) {
        for (int i = 0; i < 25; i++) {
            this.batteries[i] = batteries[i];
        }
    }

    public USP() {
        this.batteries = new Battery[25];
    }
}
