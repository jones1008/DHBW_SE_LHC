package main.infrastructure.lhc.detector;

import com.google.common.base.Stopwatch;
import com.google.common.eventbus.Subscribe;
import main.infrastructure.DBManager;
import main.infrastructure.lhc.Subscriber;
import main.infrastructure.lhc.experiment.IExperiment;
import main.infrastructure.lhc.Ring;
import main.infrastructure.Configuration;
import main.infrastructure.security.Reader;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Detector extends Subscriber implements IDetector {
    private static String higgsBosonStructure = "higgs";
    private boolean isActivated;

    private List<IExperiment> experimentList;
    private Reader reader;
    private Ring ring;

    private Object port;
    private Method searchString;

    private Stopwatch watch;

    private void createSearchMethod() {
        Object instance;
        try {
            URL[] urls = {new File(Configuration.instance.getComponentPath()).toURI().toURL()};
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
        if (Configuration.instance.loadFromDataBase) {
            selectExperiments();
        } else {
            this.experimentList = new LinkedList<>();
        }
    }

    public void addExperiment(IExperiment experiment) {
        experimentList.add(experiment);
    }

    public List<IExperiment> getExperiments() {
        return this.experimentList;
    }

    public void viewExperiments() {
        for (IExperiment experiment : experimentList) {
            System.out.println(experiment);
        }
    }

    public void search(IExperiment experiment) {
        int position = -1;
        for (int i = 0; i < 200000; i++) {
            try {
                position = (Integer) searchString.invoke(port, experiment.getBlock(i).getStructure(), higgsBosonStructure);
                if (position != -1) {
                    watch.stop();
                    experiment.setHiggsBosonFound();
                    System.out.println(experiment + ", Block:" + i + ": " + experiment.getBlock(i).getStructure() +
                            " time:" + watch.elapsed(TimeUnit.MILLISECONDS));
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object getPort() {
        return this.port;
    }


    @Subscribe
    public void receive(AnalyseEvent event) {
        this.createSearchMethod();
        watch = Stopwatch.createStarted();
        for (IExperiment experiment : experimentList) {
            search(experiment);
        }
    }

    private void selectExperiments() {
        DBManager dbMan = new DBManager();
        dbMan.setupConnection();
        this.experimentList = dbMan.selectExperiments();

        System.out.println("Experiments: " + experimentList.size());
        experimentList.forEach(e -> {
            System.out.println(e.toDatabaseString());
        });

        dbMan.shutdown();
    }
}

