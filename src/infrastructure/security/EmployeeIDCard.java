package infrastructure.security;

public class EmployeeIDCard extends IDCard {
    private Chip passwordChip;
    private Chip fingerprintChip;

    EmployeeIDCard() {
        super();
        this.passwordChip = new Chip();
        this.fingerprintChip = new Chip();
    }
}
