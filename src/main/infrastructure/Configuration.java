package main.infrastructure;

import main.infrastructure.lhc.detector.SearchAlgorithm;

public enum Configuration {
    instance;

    public String aesKey = "geheim";
    public SearchAlgorithm searchAlgorithm = SearchAlgorithm.Native;
    public String fs = System.getProperty("file.separator");
    public String userDirectory = System.getProperty("user.dir");
    public String pathToData = userDirectory + fs + "data" + fs;

    public String getComponentPath() {
        String path = userDirectory + fs;
        switch (searchAlgorithm) {
            case Native:
                path += "SA_Native" + fs + "jar" + fs + "SA_Native.jar";
                break;
            case BoyerMoore:
                path += "SA_BoyerMoore" + fs + "jar" + fs + "SA_BoyerMoore.jar";
                break;
            case KnuthMorrisPratt:
                path += "SA_KnuthMorrisPratt" + fs + "jar" + fs + "SA_KnuthMorrisPratt.jar";
                break;
        }
        return path;
    }
}
