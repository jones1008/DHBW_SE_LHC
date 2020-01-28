package infrastructure.lhc.detector;

import infrastructure.lhc.experiment.IExperiment;

public interface IDetector extends IRODetector {
    public void addExperiment(IExperiment experiment);
    public void search(IExperiment experiment);
}
