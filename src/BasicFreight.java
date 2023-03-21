public class BasicFreight extends RailroadCar {
    public BasicFreight(String shipper, String securityInfo, double netWeight, double grossWeight) {
        super("Basic Freight", shipper, securityInfo, netWeight, grossWeight);
    }

    public boolean requiresElectricalConnection() {
        return false;
    }
}
