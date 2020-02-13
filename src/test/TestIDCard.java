package test;

import main.human_resources.*;
import main.infrastructure.security.*;
import org.junit.jupiter.api.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: 6439456
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestIDCard {
    private Employee employee;

    @BeforeEach
    public void Setup() {
        ISecurityOfficer securityOfficer = new SecurityOfficer(2, "SecurityOfficer");
        ISecurityCentre securityCentre = SecurityCenter.instance;
        securityCentre.setSecurityOfficer(securityOfficer);
        employee = new ScientificAssistant(3, "ScienceAssistant");
        securityCentre.getSecurityOfficer().createIDCard(employee, EmployeeType.ScientificAssitant);
    }

    @Test
    @Order(1)
    @DisplayName("Check if visitor card is created correct")
    public void createVisitorIdCard() {
        IReceptionStaff receptionStaff = new ReceptionStaff(0, "Rezeptionist");
        IReception reception = Reception.instance;
        reception.setReceptionStaff(receptionStaff);
        Visitor visitor1 = new Visitor(1, "Besucher");
        reception.getReceptionStaff().createIDCard(visitor1);

        VisitorIDCard card = (VisitorIDCard) visitor1.getIdCard();

        assertEquals(card.getPerson(), visitor1);
        assertEquals(Arrays.equals(card.getIrisStructure(), visitor1.getIris()), true);
        assertEquals(card.getIsLocked(), false);
        assertNotEquals(card.getPermissions(), null);
        assertEquals(card.getPermissions().size(), 1);
        assertEquals(card.getPermissions().get(0), Permission.VISITOR);

        Format formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));

        assertEquals(formatter.format(card.getValidFrom()), formatter.format(today));
        assertEquals(formatter.format(card.getValidUntil()), formatter.format(tomorrow));
    }

    @Test
    @Order(2)
    @DisplayName("Check if employee card is created correct")
    public void createEmployeeIdCard() {
        EmployeeIDCard card = (EmployeeIDCard) this.employee.getIdCard();

        assertEquals(card.getPerson(), this.employee);
        assertEquals(Arrays.equals(card.getIrisStructure(), this.employee.getIris()), true);
        assertEquals(card.getIsLocked(), false);
        assertNotEquals(card.getPermissions(), null);
        assertEquals(card.getPermissions().size(), 1);
        assertEquals(card.getPermissions().contains(Permission.CONTROLCENTER), true);

        Format formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date today = new Date();
        Date until = new Date(today.getTime() + (1000 * 60 * 60 * 24 * 365));

        assertEquals(formatter.format(card.getValidFrom()), formatter.format(today));
        assertEquals(formatter.format(card.getValidUntil()), formatter.format(until));
    }

    @Test
    @Order(3)
    @DisplayName("Lock ID card if password is wrong three times")
    public void lockIdCard() {
        IReader reader = new Reader();
        reader.insertIDCard(this.employee.getIdCard());

        reader.verifyPassword("helloLHC20201");
        reader.verifyPassword("helloLHC20201");
        reader.verifyPassword("helloLHC20201");

        assertEquals(this.employee.getIdCard().getIsLocked(), true);
    }

    @Test
    @Order(4)
    @DisplayName("Deny card if it is locked")
    public void denyLockedIdCard() {
        IReader reader = new Reader();
        this.employee.getIdCard().setIsLocked(true);

        reader.insertIDCard(this.employee.getIdCard());

        assertEquals(reader.getCurrentIdCard(), null);
    }

    @Test
    @Order(5)
    @DisplayName("Deny card if it is expired")
    public void denyExpiredIdCard() {
        IReader reader = new Reader();
        Date date = new Date();
        this.employee.getIdCard().setValidUntil(new Date(date.getTime() - 1000));
        reader.insertIDCard(this.employee.getIdCard());

        assertEquals(reader.getCurrentIdCard(), null);
    }
}
