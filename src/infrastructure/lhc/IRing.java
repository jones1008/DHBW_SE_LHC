package infrastructure.lhc;

public interface IRing{
    public void activate();

    public void activate(int initialEnergy);

    public void activateMagneticField();

    public void releaseProton();

    public void increaseEnergy(int delta);

    public void collide(Proton proton01, Proton proton02);

    public int decreaseEnergy();

    public void shutdown();

}
