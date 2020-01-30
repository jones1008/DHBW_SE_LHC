package infrastructure.lhc.detector;

import com.google.common.base.Stopwatch;
import com.google.common.eventbus.Subscribe;
import infrastructure.lhc.Subscriber;
import infrastructure.lhc.experiment.IExperiment;
import infrastructure.lhc.Ring;
import infrastructure.Configuration;
import infrastructure.security.Reader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

public class Detector extends Subscriber implements IDetector {
    private static String higgsBosonStructure = "higgs";
    private boolean isActivated;

    private LinkedList<IExperiment> experimentList;
    private Reader reader;
    private Ring ring;

    private Object port;
    private Method searchString;

    private Stopwatch watch;

    private void createSearchMethod() {
        Object instance;
        try {
            URL[] urls = {new File(Configuration.instance.pathToJar).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, Detector.class.getClassLoader());
            Class clazz = Class.forName(Configuration.instance.searchAlgorithm.toString(), true, urlClassLoader);

            instance = clazz.getMethod("getInstance").invoke(null);
            port = clazz.getDeclaredField("port").get(instance);

            searchString = port.getClass().getMethod("search", String.class, String.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Detector() {
        super();
        this.experimentList = new LinkedList<>();
        createSearchMethod();
    }

    public void addExperiment(IExperiment experiment) {
        experimentList.add(experiment);
    }

    public void viewExperiments() {
        for (IExperiment experiment : experimentList) {
            System.out.println(experiment);
        }
    }

    public void search(IExperiment experiment) {
        int pos = -1;
        for (int i = 0; i < 200000; i++) {
            try {
                pos = (Integer) searchString.invoke(port, experiment.getBlock(i).getStructure(), higgsBosonStructure);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (pos != -1) {
                watch.stop();
                experiment.setHiggsBosonFound();
                System.out.println(experiment + ", Block:" + i + ": " + experiment.getBlock(i).getStructure() +
                        " time:" + watch.elapsed(TimeUnit.MILLISECONDS));
                return;
            }
        }
    }


    @Subscribe
    public void receive(AnalyseEvent event) {
        watch = Stopwatch.createStarted();
        String s = experimentList.get(16).getBlock(143389).getStructure();
        for (IExperiment experiment : experimentList) {
            search(experiment);
        }
    }
}

