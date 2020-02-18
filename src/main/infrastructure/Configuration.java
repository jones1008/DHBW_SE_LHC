package main.infrastructure;

import main.infrastructure.lhc.detector.SearchAlgorithm;

public enum Configuration {
    instance;

    public String aesKey = "geheim";
    public SearchAlgorithm searchAlgorithm = SearchAlgorithm.Native;
    public String fs = System.getProperty("file.separator");
    public String userDirectory = System.getProperty("user.dir");

    public final String databaseDir = userDirectory + fs + "database" + fs;
    public final String dataBaseFile = databaseDir + "dataStore.db";
    public final String username = "test";
    public final String password = "asd";

    public String pathToJar = getComponentPath();
    public String pathToData = userDirectory + fs + "data" + fs;

    public boolean loadFromDataBase = true;

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
