package main.infrastructure.lhc;

import main.infrastructure.Building;
import main.infrastructure.energy.IUSP;
import main.infrastructure.energy.USP;

public class LargeHadronCollider implements ILargeHadronCollider{

    private Building building;
    private IUSP[] usp;
    private IRing ring;

    public LargeHadronCollider() {
        this.usp = new USP[2];
    }

    public void setRing(IRing ring) {
        this.ring = ring;
    }

    public void setUSPs(IUSP usp1, IUSP usp2) {
        this.usp[0] = usp1;
        this.usp[1] = usp2;
    }

    public IRing getRing() {
        return this.ring;
    }

    public IUSP[] getUSPs() {
        return this.usp;
    }
}
