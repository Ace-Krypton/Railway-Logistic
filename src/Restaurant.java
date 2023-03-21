public class Restaurant extends RailroadCar {
    public Restaurant(String shipper, String securityInfo, double netWeight, double grossWeight) {
        super("Restaurant", shipper, securityInfo, netWeight, grossWeight);
    }

    public boolean requiresElectricalConnection() {
        return false;
    }
}
