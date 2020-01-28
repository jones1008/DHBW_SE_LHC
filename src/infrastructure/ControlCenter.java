package infrastructure;

import com.google.common.eventbus.EventBus;
import infrastructure.lhc.experiment.ExperimentScope;
import infrastructure.lhc.Subscriber;
import infrastructure.lhc.experiment.RunExperimentFullEvent;

public enum ControlCenter implements IControlCenter {
    instance;
    private String roomID;

    private Workplace workplace;

    private EventBus eventBus;

    ControlCenter() {
         this.roomID = "C01";
         eventBus = new EventBus(roomID);
    }

    public void addSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public void startExperiment() {
        eventBus.post(new RunExperimentFullEvent(50));
    }

    public void startExperiment(ExperimentScope scope) {
        eventBus.post(new RunExperimentFullEvent(50));
    }
}

