import java.util.ArrayList;
import java.util.Date;

public class IDCard {
    private String id;
    private Date validFrom;
    private Date validUntil;
    private int[][] irisStructure;
    private ArrayList<Permission> permissionList;
    private boolean isLocked;

    private Person person;
    private Chip chip;

    public IDCard() {
        this.irisStructure = new int[10][10];
        this.chip = new Chip();
    }
}

