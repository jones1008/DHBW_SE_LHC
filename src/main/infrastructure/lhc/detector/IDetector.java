package main.infrastructure.lhc.detector;

import main.infrastructure.lhc.experiment.IExperiment;

import java.util.List;

public interface IDetector extends IRODetector {
    public void addExperiment(IExperiment experiment);
    List<IExperiment> getExperiments();
    public void search(IExperiment experiment);
    Object getPort();
}
