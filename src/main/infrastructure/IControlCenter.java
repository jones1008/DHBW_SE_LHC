package main.infrastructure;

import main.infrastructure.lhc.experiment.ExperimentScope;
import main.infrastructure.lhc.Subscriber;

public interface IControlCenter {
    public void addSubscriber(Subscriber subscriber);
    public void startExperiment(int initialEnergy);
    public void startExperiment(int initialEnergy, ExperimentScope scope);
    IWorkplace[] getWorkplaces();
    void setWorkplaces(IWorkplace[] workplaces);
}
