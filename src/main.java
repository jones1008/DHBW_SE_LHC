import human_resources.*;
import infrastructure.lhc.Detector;
import infrastructure.lhc.Experiment;
import infrastructure.lhc.IRODetector;
import infrastructure.security.*;

public class main {
    public static void main(String[] args) {
        createVisitorIDCard();
        createEmployeeIDCard();
        checkVisitor();
        checkEmployee();
        researcherAccessesDetector();
        hrAssistantAccessesEmployees();
        securityCentreLocksIDCard();
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
        securityCentre.getSecurityOfficer().createIDCard(scientificAssistant1);
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
        securityCentre.getSecurityOfficer().createIDCard(scientificAssistant1);

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
        securityCentre.getSecurityOfficer().createIDCard(employee);

        securityCentre.lockEmployeeIDCard(employee);
    }
}