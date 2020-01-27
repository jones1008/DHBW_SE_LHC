package infrastructure.security;

public class VisitorIDCard extends IDCard {
    private IChip passwordChip;

    public VisitorIDCard(String id) {
        super(id);
        this.passwordChip = new Chip();
    }

    @Override
    public String getData() {
        return passwordChip.toString();
    }

    public void setPassword(String password) {
        passwordChip.setData(password);
    }
}
