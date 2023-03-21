import java.util.ArrayList;

public class Passenger extends RailroadCar {
    public static final ArrayList<Passenger> passengers = new ArrayList<>();
    private final int numSeats;

    public Passenger(String shipper, String securityInfo, double netWeight, double grossWeight,
                     int numSeats) {
        super("Passenger", shipper, securityInfo, netWeight, grossWeight);
        this.numSeats = numSeats;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public boolean requiresElectricalConnection() {
        return true;
    }

    @Override
    public String toString() {
        return "Number of seats: " + getNumSeats()
                + "\nDoes require electrical connection?: " + requiresElectricalConnection();
    }
}
