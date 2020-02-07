package main.infrastructure.lhc;

import main.infrastructure.lhc.detector.IDetector;

public interface IRing{
    public void activate();

    public void activate(int initialEnergy);

    public void activateMagneticField();

    public void releaseProton();

    public void increaseEnergy(int delta);

    public void collide();

    public int decreaseEnergy();

    public void shutdown();

    public void setProtonTraps(IProtonTrap protonTrap01, IProtonTrap protonTrap02);

    public void setDetector(IDetector detector);

}
