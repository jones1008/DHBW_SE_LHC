package infrastructure;

import infrastructure.lhc.experiment.ExperimentScope;
import infrastructure.lhc.Subscriber;

public interface IControlCenter {
    public void addSubscriber(Subscriber subscriber);
    public void startExperiment();
    public void startExperiment(ExperimentScope scope);
}
