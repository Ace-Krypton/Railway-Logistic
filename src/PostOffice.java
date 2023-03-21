public class PostOffice extends RailroadCar {
    public PostOffice(String shipper, String securityInfo, double netWeight, double grossWeight) {
        super("Post Office", shipper, securityInfo, netWeight, grossWeight);
    }

    public boolean requiresElectricalConnection() {
        return true;
    }
}
