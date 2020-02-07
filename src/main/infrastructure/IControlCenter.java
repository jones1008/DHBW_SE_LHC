package main.infrastructure;

import main.infrastructure.lhc.experiment.ExperimentScope;
import main.infrastructure.lhc.Subscriber;

public interface IControlCenter {
    public void addSubscriber(Subscriber subscriber);
    public void startExperiment();
    public void startExperiment(ExperimentScope scope);
    IWorkplace[] getWorkplaces();
    void setWorkplaces(IWorkplace[] workplaces);
}
