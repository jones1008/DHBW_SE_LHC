import main.infrastructure.DBManager;
import main.human_resources.*;
import main.infrastructure.ControlCenter;
import main.infrastructure.Workplace;
import main.infrastructure.lhc.ProtonTrap;
import main.infrastructure.lhc.ProtonTrapID;
import main.infrastructure.lhc.Ring;
import main.infrastructure.lhc.detector.Detector;
import main.infrastructure.lhc.experiment.Experiment;
import main.infrastructure.lhc.experiment.ExperimentScope;
import main.infrastructure.lhc.experiment.IExperiment;
import main.infrastructure.security.*;
import main.ScenarioManager;
import main.Scenario;
import main.MementoCareTaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class main {
    public static void main(String[] args) {
//        createVisitorIDCard();
//        createEmployeeIDCard();
//        checkVisitor();
//        checkEmployee();
//        researcherAccessesDetector();
//        hrAssistantAccessesEmployees();
//        securityCentreLocksIDCard();
//        collide();

//        createDB();
//        selectExperiments();

        executeScenarios();
    }

    private static void executeScenarios() {
        ProtonTrap trap1 = new ProtonTrap(ProtonTrapID.A);
        ProtonTrap trap2 = new ProtonTrap(ProtonTrapID.B);

        Ring ring = new Ring();
        Detector detector = new Detector();
        ControlCenter controlCenter = ControlCenter.instance;

        ring.setProtonTraps(trap1, trap2);
        ring.setDetector(detector);

        controlCenter.addSubscriber(ring);
        controlCenter.addSubscriber(detector);

        // create visitor, assistant and researcher
        Visitor visitor = new Visitor(1, "Victor Visitor");
        ScientificAssistant scientificAssistant = new ScientificAssistant(2, "Simon ScientificAssistant");
        Researcher researcher = new Researcher(3, "Robin Researcher");

        // create researchGroup
        ResearchGroup researchGroup = new ResearchGroup(researcher);
        ArrayList<ScientificAssistant> scientificAssistants = new ArrayList<>();
        scientificAssistants.add(scientificAssistant);
        researchGroup.setScientificAssistants(scientificAssistants);

        // create workplace
        Workplace workplace = new Workplace();
        workplace.setResearchGroup(researchGroup);
        workplace.setVisitor(visitor);

        // create scenarios
        scientificAssistant.createScenario(researcher, 10, 50);
        scientificAssistant.createScenario(researcher, 5, 100);


        MementoCareTaker mementoCareTaker = new MementoCareTaker();

        // save and print scenarios
        Scenario scenario1 = ScenarioManager.instance.getScenario(0);
        Scenario scenario2 = ScenarioManager.instance.getScenario(1);
        mementoCareTaker.setMemento(scenario1.save());
        System.out.println(scenario1);

        // change some values of scenario1
        System.out.println("change some values");
        scenario1.setInitialEnergy(200);
        scenario1.setNumberOfExperiments(20);
        System.out.println(scenario1);

        // restore scenario1
        System.out.println("restore scenario");
        scenario1.restore(mementoCareTaker.getMemento());
        System.out.println(scenario1);

        // change some values of scenario2
        System.out.println("change some values again");
        scenario2.setInitialEnergy(300);
        scenario2.setNumberOfExperiments(15);
        System.out.println(scenario2);

        // loop over saved scenarios
        System.out.println();
        System.out.println("executing them scenarios");
        TreeMap<Integer, Scenario> scenarios = ScenarioManager.instance.getScenarios();
        for(Map.Entry<Integer, Scenario> scenario : scenarios.entrySet()) {
            System.out.println(scenario.getValue());
            ring.executeScenario(scenario.getValue());
        }
    }

    private static void createDB() {
        ProtonTrap trap1 = new ProtonTrap(ProtonTrapID.A);
        ProtonTrap trap2 = new ProtonTrap(ProtonTrapID.B);

        Ring ring = new Ring();
        Detector detector = new Detector();
        ControlCenter controlCenter = ControlCenter.instance;

        ring.setProtonTraps(trap1, trap2);
        ring.setDetector(detector);

        controlCenter.addSubscriber(ring);
        controlCenter.addSubscriber(detector);

        controlCenter.startExperiment(50, ExperimentScope.ES20);

        DBManager dbMan = new DBManager();
        dbMan.setupConnection();
        dbMan.createExperimentTable();

        List<IExperiment> list = detector.getExperiments();
        list.subList(14, 19).forEach(e -> {
            dbMan.insertExperiment(e);
        });

        dbMan.shutdown();
    }

    // Anwendungsfall 1
    private static void createVisitorIDCard() {
        IReceptionStaff receptionStaff = new ReceptionStaff(0, "Rainer Rezeptionist");
        IReception reception = Reception.instance;
        reception.setReceptionStaff(receptionStaff);
        Visitor visitor1 = new Visitor(1, "Berthold Besucher");
        reception.getReceptionStaff().createIDCard(visitor1);
    }

    // Anwendungsfall 2
    private static void createEmployeeIDCard() {
        ISecurityOfficer securityOfficer = new SecurityOfficer(2, "Siegfried Security");
        ISecurityCentre securityCentre = SecurityCenter.instance;
        securityCentre.setSecurityOfficer(securityOfficer);
        ScientificAssistant scientificAssistant1 = new ScientificAssistant(3, "Anton Assistent");
        securityCentre.getSecurityOfficer().createIDCard(scientificAssistant1, EmployeeType.ScientificAssitant);
    }

    // Anwendungsfall 3
    private static void checkVisitor() {
        IReceptionStaff receptionStaff = new ReceptionStaff(0, "Rainer Rezeptionist");
        IReception reception = Reception.instance;
        reception.setReceptionStaff(receptionStaff);
        Visitor visitor1 = new Visitor(1, "Berthold Besucher");
        reception.getReceptionStaff().createIDCard(visitor1);

        IReader reader = new Reader();
        reader.insertIDCard(visitor1.getIdCard());

        System.out.println(reader.verifyPassword("12345"));
    }

    // Anwendungsfall 4
    private static void checkEmployee() {
        ISecurityOfficer securityOfficer = new SecurityOfficer(2, "Siegfried Security");
        ISecurityCentre securityCentre = SecurityCenter.instance;
        securityCentre.setSecurityOfficer(securityOfficer);
        ScientificAssistant scientificAssistant1 = new ScientificAssistant(3, "Anton Assistent");
        securityCentre.getSecurityOfficer().createIDCard(scientificAssistant1, EmployeeType.ScientificAssitant);

        IReader reader = new Reader();
        reader.insertIDCard(scientificAssistant1.getIdCard());

        System.out.println(reader.verifyPassword("helloLHC2020"));
    }

    // Anwendungsfall 5
    private static void researcherAccessesDetector() {
        Detector detector = new Detector();
        for (int i = 0; i < 5; i++) {
            detector.addExperiment(new Experiment());
        }
        Researcher researcher = new Researcher(4, "Friedrich Forscher");
        researcher.setDetector(detector);
        researcher.getDetector().viewExperiments();
    }

    // Andwendungsfall 6
    private static void hrAssistantAccessesEmployees() {
        IEmployeeManagement employeeManagement = EmployeeManagement.instance;
        try {
            employeeManagement.createEmployee("Simon Security", "SecurityOfficer");
            employeeManagement.createEmployee("Frauke Forscher", "Researcher");
            employeeManagement.createEmployee("Astrid Assistentin", "ScientificAssistant");
        } catch (Exception e) {
            e.printStackTrace();
        }
        HRAssistant assistant = new HRAssistant(5, "Peter Personaler");
        assistant.getEmployeeManagement().viewEmployeeData();
    }

    // Anwendungsfall 7
    private static void securityCentreLocksIDCard() {
        ISecurityCentre securityCentre = SecurityCenter.instance;

        // create Officer
        ScientificAssistant employee = new ScientificAssistant(3, "Arnulf Assistent");
        securityCentre.getSecurityOfficer().createIDCard(employee, EmployeeType.ScientificAssitant);

        securityCentre.lockEmployeeIDCard(employee);
    }

    private static void collide() {
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
//        controlCenter.startExperiment(ExperimentScope.ES20);
    }
}
