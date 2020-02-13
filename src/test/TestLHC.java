package test;

import main.infrastructure.energy.*;
import main.infrastructure.lhc.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

/**
 * @Author: 6439456
 */

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestLHC {
    private ILargeHadronCollider largeHadronCollider;

    @BeforeEach
    public void Setup() {
        this.largeHadronCollider = new LargeHadronCollider();
        this.largeHadronCollider.setRing(new Ring());
        this.largeHadronCollider.setUSPs(new USP(), new USP());

        Battery[] batteries1 = new Battery[25];
        for (int i = 0; i < 25; i++) {
            batteries1[i] = new Battery();
        }
        Battery[] batteries2 = new Battery[25];
        for (int i = 0; i < 25; i++) {
            batteries2[i] = new Battery();
        }

        this.largeHadronCollider.getUSPs()[0].setBatteries(batteries1);
        this.largeHadronCollider.getUSPs()[1].setBatteries(batteries2);
    }

    @Test
    @Order(1)
    @DisplayName("Check assignments for LHC")
    public void lhcAssignment() {
        assertNotEquals(this.largeHadronCollider, null);

        assertNotEquals(this.largeHadronCollider.getRing(), null);

        assertNotEquals(this.largeHadronCollider.getUSPs(), null);
        assertEquals(this.largeHadronCollider.getUSPs().length, 2);
        assertNotEquals(this.largeHadronCollider.getUSPs()[0], null);
        assertNotEquals(this.largeHadronCollider.getUSPs()[1], null);
    }

    @Test
    @Order(2)
    @DisplayName("Check assignment for USPs and batteries")
    public void usp25batteries() {
        assertEquals(this.largeHadronCollider.getUSPs()[0].getBatteries().length, 25);
        for (int i = 0; i < 25; i++)
            assertNotEquals(this.largeHadronCollider.getUSPs()[0].getBatteries()[i], null);

        assertEquals(this.largeHadronCollider.getUSPs()[1].getBatteries().length, 25);
        for (int i = 0; i < 25; i++)
            assertNotEquals(this.largeHadronCollider.getUSPs()[1].getBatteries()[i], null);
    }
}
