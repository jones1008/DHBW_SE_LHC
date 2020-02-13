package main.infrastructure.security;

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

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("'" + getId() + "', " + getValidFrom().toString() + "', '" + getValidUntil().toString() + "', '");

        for (int i = 0; i < getIrisStructure().length; i++) {
            for (int j = 0; j < getIrisStructure()[i].length; j++) {
                ret.append(Integer.toString(getIrisStructure()[i][j])).append(",");
            }
        }

        ret.append("', ").append(getIsLocked()).append(", ");
        this.getPermissions().forEach((e) -> {
            ret.append(e.toString() + ',');
        });

        ret.append("', "+ Integer.toString(getInvalidPwdCounter()) + ", " + getPerson().getId());
        return ret.toString();
    }
}
