package infrastructure.lhc.detector;

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

public class Detector extends Subscriber implements IRODetector {
    private static String higgsBosonStructure = "higgs";
    private boolean isActivated;

    private LinkedList<IExperiment> experimentList;
    private Reader reader;
    private Ring ring;

    private Object port;
    private Method searchString;

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
                pos = (Integer) searchString.invoke(port, experiment.getBlock(i), higgsBosonStructure);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (pos != -1) {
                experiment.setHiggsBosonFound();
                return;
            }
        }
    }


    @Subscribe
    public void receive(AnalyseEvent event) {

    }
}

