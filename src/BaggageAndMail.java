public class BaggageAndMail extends RailroadCar {
    public BaggageAndMail(String shipper, String securityInfo, double netWeight, double grossWeight) {
        super("Baggage And Mail", shipper, securityInfo, netWeight, grossWeight);
    }

    public boolean requiresElectricalConnection() {
        return false;
    }
}
