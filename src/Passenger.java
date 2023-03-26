public class Passenger extends RailroadCar {
    private final int numSeats;
    private final int numLuggageRacks;
    private final String typeOfSeat;

    public Passenger(String shipper, String securityInfo, double netWeight, double grossWeight,
                     int numSeats, int numLuggageRacks, String typeOfSeat) {
        super("Passenger", shipper, securityInfo, netWeight, grossWeight);
        this.numSeats = numSeats;
        this.numLuggageRacks = numLuggageRacks;
        this.typeOfSeat = typeOfSeat;
    }

    public String getTypeOfSeat() {
        return typeOfSeat;
    }

    public int getNumLuggageRacks() {
        return numLuggageRacks;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public boolean requiresElectricalConnection() {
        return true;
    }
}
