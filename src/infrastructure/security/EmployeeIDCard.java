package infrastructure.security;

import java.util.ArrayList;
import java.util.Date;

public class EmployeeIDCard extends IDCard {
    private IChip passwordChip;
    private IChip fingerprintChip;

    EmployeeIDCard(String id) {
        super(id);
        this.passwordChip = new Chip();
        this.fingerprintChip = new Chip();
    }

    public void setPassword(String password) {
        passwordChip.setData(password);
        this.communication.setData(password);
    }
}
