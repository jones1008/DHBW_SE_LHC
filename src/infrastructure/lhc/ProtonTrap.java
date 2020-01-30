package infrastructure.lhc;

import infrastructure.Configuration;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayDeque;
import java.util.Queue;

public class ProtonTrap implements IProtonTrap {
    private ProtonTrapID id;

    private Ring ring;
    private Queue<Proton> protons;

    public void loadData(String dataFilePath, int id) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(dataFilePath)));
            int[][][] structure = new int[100][100][100];

            int counter = 0;
            for (int i = 0; i < structure.length; i++) {
                for (int j = 0; j < structure[i].length; j++) {
                    for (int k = 0; k < structure[j].length; k++) {
                        structure[i][j][k] = content.charAt(counter);
                        counter++;
                    }
                }
            }

            protons.add(new Proton(id, structure));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Proton release() {
        return protons.poll();
    }

    public ProtonTrap(ProtonTrapID id) {
        this.id = id;
        this.protons = new ArrayDeque<>();

        int i = id.equals(ProtonTrapID.A) ? 1 : 2;
        for (i = i; i <= 50; i += 2) {
            String number = String.format("%02d", i);
            loadData(Configuration.instance.pathToData + "proton_" + number + ".txt", i);
        }
    }
}

