package main.infrastructure.lhc;

import main.infrastructure.energy.IUSP;

public interface ILargeHadronCollider {
    void setRing(IRing ring);
    void setUSPs(IUSP usp1, IUSP usp2);
    IRing getRing();
    IUSP[] getUSPs();
}
