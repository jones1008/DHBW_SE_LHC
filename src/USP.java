public class USP {
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

    public USP() {
        this.batteries = new Battery[25];
    }
}
