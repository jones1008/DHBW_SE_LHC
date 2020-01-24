package infrastructure.lhc;

import infrastructure.Building;
import infrastructure.energy.USP;

public class LargeHadronCollider {

    private Building building;
    private USP[] usp;
    private Ring ring;

    public LargeHadronCollider() {
        this.usp = new USP[2];
    }
}
