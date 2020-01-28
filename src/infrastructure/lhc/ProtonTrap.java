package infrastructure.lhc;

import infrastructure.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProtonTrap {
    private ProtonTrapID id;

    private Ring ring;
    private List<Proton> protons;

    public void loadData(String dataFilePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(dataFilePath)));
            int[][][] structure = new int[100][100][100];

            int counter = 0;
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    for (int k = 0; k < 100; k++) {
                        structure[i][j][k] = content.charAt(counter);
                        counter++;
                    }
                }
            }

            protons.add(new Proton(structure));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release() {

    }

    public ProtonTrap(ProtonTrapID id, boolean odd) {
        this.id = id;
        this.protons = new ArrayList<>();

        int i = odd ? 1 : 2;
        for (i = i; i <= 50; i += 2) {
            String number = String.format("%02d", i);
            loadData(Configuration.instance.pathToData + "proton_" + number + ".txt");
        }
    }
}

