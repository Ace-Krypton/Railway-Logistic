public class HeavyFreight extends RailroadCar {
    public HeavyFreight(String shipper, String securityInfo, double netWeight, double grossWeight) {
        super("Heavy Freight", shipper, securityInfo, netWeight, grossWeight);
    }

    public boolean requiresElectricalConnection() {
        return false;
    }
}
