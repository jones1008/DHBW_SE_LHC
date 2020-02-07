package test;

import main.human_resources.IResearchGroup;
import main.human_resources.ResearchGroup;
import main.human_resources.Researcher;
import main.infrastructure.ControlCenter;
import main.infrastructure.IControlCenter;
import main.infrastructure.IWorkplace;
import main.infrastructure.Workplace;
import org.junit.jupiter.api.*;

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
    @DisplayName("")
    public void detectorInitialized() {

    }

    @Test
    @Order(3)
    @DisplayName("")
    public void ringInitialisation() {

    }

    @Test
    @Order(4)
    @DisplayName("")
    public void protonTrapInitialisation() {

    }

    @Test
    @Order(5)
    @DisplayName("")
    public void takeFirstProtonInExperiment() {

    }

    @Test
    @Order(6)
    @DisplayName("")
    public void collideAt300000Energy() {

    }

    @Test
    @Order(7)
    @DisplayName("")
    public void experimentSuccessfullyInitialized() {

    }

    @Test
    @Order(8)
    @DisplayName("")
    public void higgsFound() {

    }
}
