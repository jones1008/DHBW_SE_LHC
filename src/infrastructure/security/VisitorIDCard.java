package infrastructure.security;

public class VisitorIDCard extends IDCard {
    private Chip passwordChip;

    VisitorIDCard() {
        super();
        this.passwordChip = new Chip();
    }
}
