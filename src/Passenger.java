public class Passenger extends RailroadCar {
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
}
