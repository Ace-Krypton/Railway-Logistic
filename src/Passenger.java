import java.util.ArrayList;

public class Passenger {
    private static final ArrayList<Passenger> passangers = new ArrayList<>();
    private final boolean connection = true;
    private String shipper;
    private String securityInformation;
    private double netWeight;
    private double grossWeight;
    private int numberOfSeats;
    private static int id;
    public int ID;

    public Passenger() {
        ++id;
        ID = id;
    }

    public String getShipper() {
        return shipper;
    }

    @Override
    public String toString() {
        return ID + ". "
                + "Shipper: " + getShipper();
    }
}
