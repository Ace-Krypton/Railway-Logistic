public class PostOffice extends RailroadCar {
    private final int numOfMailSlots;
    private final double maxWeightForMail;

    public PostOffice(String shipper, String securityInfo, double netWeight, double grossWeight,
                      int numOfMailSlots, double maxWeightForMail) {
        super("Post Office", shipper, securityInfo, netWeight, grossWeight, true);
        this.numOfMailSlots = numOfMailSlots;
        this.maxWeightForMail = maxWeightForMail;
    }

    public double getMaxWeightForMail() {
        return maxWeightForMail;
    }

    public int getNumOfMailSlots() {
        return numOfMailSlots;
    }

    public boolean requiresElectricalConnection() {
        return true;
    }
}
