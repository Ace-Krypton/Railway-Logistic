public class BaggageAndMail extends RailroadCar {
    private final int maxCompartment;
    private final double maxWeightCapacity;

    public BaggageAndMail(String shipper, String securityInfo, double netWeight,
                          double grossWeight, int maxCompartment, double maxWeightCapacity) {
        super("Baggage And Mail", shipper, securityInfo, netWeight, grossWeight);
        this.maxCompartment = maxCompartment;
        this.maxWeightCapacity = maxWeightCapacity;
    }

    public double getMaxWeightCapacity() {
        return maxWeightCapacity;
    }

    public int getMaxCompartment() {
        return maxCompartment;
    }

    public boolean requiresElectricalConnection() {
        return false;
    }
}
