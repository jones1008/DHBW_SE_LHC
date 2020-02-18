package test;

import main.human_resources.*;
import main.infrastructure.*;
import main.infrastructure.lhc.*;
import main.infrastructure.lhc.detector.*;
import main.infrastructure.lhc.experiment.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: 6439456
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestExperiment {
    @Test
    @Order(1)
    @DisplayName("Check if control center is correct initialized")
    public void controlCenterInitialized() {
        Researcher researcher1 = new Researcher(0, "Researcher1");
        Researcher researcher2 = new Researcher(0, "Researcher2");
        Researcher researcher3 = new Researcher(0, "Researcher3");
        IResearchGroup researchGroup1 = new ResearchGroup(researcher1);
        IResearchGroup researchGroup2 = new ResearchGroup(researcher2);
        IResearchGroup researchGroup3 = new ResearchGroup(researcher3);
        IWorkplace workplace1 = new Workplace();
        IWorkplace workplace2 = new Workplace();
        IWorkplace workplace3 = new Workplace();
        IControlCenter controlCenter = ControlCenter.instance;

        researchGroup1.setWorkplace(workplace1);
        researchGroup2.setWorkplace(workplace2);
        researchGroup3.setWorkplace(workplace3);
        workplace1.setResearchGroup(researchGroup1);
        workplace2.setResearchGroup(researchGroup2);
        workplace3.setResearchGroup(researchGroup3);
        IWorkplace[] workplaces = new IWorkplace[]{ workplace1, workplace2, workplace3};
        controlCenter.setWorkplaces(workplaces);

        assertNotEquals(controlCenter.getWorkplaces(), null);
        assertEquals(controlCenter.getWorkplaces().length, 3);
        for (int i = 0; i < 3; i++) {
            assertNotEquals(controlCenter.getWorkplaces()[i], null);
            assertNotEquals(controlCenter.getWorkplaces()[i].getResearchGroup(), null);
            assertEquals(controlCenter.getWorkplaces()[i].getResearchGroup().getResearchers().size() > 0, true);
        }
    }

    @Test
    @Order(2)
    @DisplayName("Check if all search algorithms work")
    public void detectorInitialized() {
        Configuration config = Configuration.instance;
        Detector detector;

        config.searchAlgorithm = SearchAlgorithm.Native;
        detector = new Detector();
        detector.receive(new AnalyseEvent());
        assertNotEquals(detector.getPort(), null);

        config.searchAlgorithm = SearchAlgorithm.BoyerMoore;
        detector = new Detector();
        detector.receive(new AnalyseEvent());
        assertNotEquals(detector.getPort(), null);

        config.searchAlgorithm = SearchAlgorithm.KnuthMorrisPratt;
        detector = new Detector();
        detector.receive(new AnalyseEvent());
        assertNotEquals(detector.getPort(), null);
    }

    @Test
    @Order(3)
    @DisplayName("")
    public void ringInitialisation() {
    }

    @Test
    @Order(4)
    @DisplayName("Test if all proton traps are initialized correctly")
    public void protonTrapInitialisation() {
        int protCount = 0;
        ProtonTrap trap1 = new ProtonTrap(ProtonTrapID.A);
        ProtonTrap trap2 = new ProtonTrap(ProtonTrapID.B);
        Proton proton1;
        Proton proton2;

        do {
            proton1 = trap1.release();
            proton2 = trap2.release();
            if (proton1 != null && proton2 != null) {
                protCount++;
                int[][][] struct1 = proton1.getStructure();
                int[][][] struct2 = proton1.getStructure();
                assertEquals(struct1.length, 100);
                assertEquals(struct2.length, 100);
                for (int i = 0; i < 100; i++) {
                    assertEquals(struct1[i].length, 100);
                    assertEquals(struct2[i].length, 100);
                    for (int j = 0; j < 100; j++) {
                        assertEquals(struct1[i][j].length, 100);
                        assertEquals(struct2[i][j].length, 100);
                    }
                }
            }
        } while (proton1 != null && proton2 != null);
        assertEquals(protCount, 25);
    }

    @Test
    @Order(5)
    @DisplayName("Check if first proton is taken from trap")
    public void takeFirstProtonInExperiment() {

    }

    @Test
    @Order(6)
    @DisplayName("")
    public void collideAt300000Energy() {

    }

    @Test
    @Order(7)
    @DisplayName("Test if experiment is successful initialized")
    public void experimentSuccessfullyInitialized() {
        ProtonTrap trap1 = new ProtonTrap(ProtonTrapID.A);
        ProtonTrap trap2 = new ProtonTrap(ProtonTrapID.B);

        Ring ring = new Ring();
        Detector detector = new Detector();
        ControlCenter controlCenter = ControlCenter.instance;

        ring.setProtonTraps(trap1, trap2);
        ring.setDetector(detector);

        controlCenter.addSubscriber(ring);
        controlCenter.addSubscriber(detector);

        controlCenter.startExperiment(50, ExperimentScope.ES5);
        IExperiment experiment = detector.getExperiments().get(0);

        for (int i = 0; i < 200000; i++) {
            assertEquals(experiment.getBlock(i).getStructure().length(), 10);
        }
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> { experiment.getBlock(200000); });
    }

    @Test
    @Order(8)
    @DisplayName("Check if higgs was found")
    public void higgsFound() {
        ProtonTrap trap1 = new ProtonTrap(ProtonTrapID.A);
        ProtonTrap trap2 = new ProtonTrap(ProtonTrapID.B);

        Ring ring = new Ring();
        Detector detector = new Detector();
        ControlCenter controlCenter = ControlCenter.instance;

        ring.setProtonTraps(trap1, trap2);
        ring.setDetector(detector);

        controlCenter.addSubscriber(ring);
        controlCenter.addSubscriber(detector);

        controlCenter.startExperiment(50);

        assertEquals(detector.getExperiments().get(16).getHiggsBosonFound(), true);
    }
}
