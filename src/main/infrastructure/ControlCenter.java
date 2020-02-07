package main.infrastructure;

import com.google.common.eventbus.EventBus;
import main.infrastructure.lhc.detector.AnalyseEvent;
import main.infrastructure.lhc.experiment.ExperimentScope;
import main.infrastructure.lhc.Subscriber;
import main.infrastructure.lhc.experiment.RunExperimentFullEvent;
import main.infrastructure.lhc.experiment.RunExperimentPartialEvent;

public enum ControlCenter implements IControlCenter {
    instance;
    private String roomID;

    private IWorkplace[] workplaces;

    private EventBus eventBus;

    ControlCenter() {
         this.roomID = "C01";
         eventBus = new EventBus(roomID);
         this.workplaces = new Workplace[3];
    }

    public void addSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public void startExperiment() {
        eventBus.post(new RunExperimentFullEvent(50));
        eventBus.post(new AnalyseEvent());
    }

    public void startExperiment(ExperimentScope scope) {
        eventBus.post(new RunExperimentPartialEvent(50, scope));
        eventBus.post(new AnalyseEvent());
    }

    public IWorkplace[] getWorkplaces() {
        return this.workplaces;
    }

    public void setWorkplaces(IWorkplace[] workplaces) {
        this.workplaces = workplaces;
    }
}

