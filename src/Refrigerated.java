public class Refrigerated extends BasicFreight {
    private final double maxTemperature;
    private final boolean remoteMonitored;

    public Refrigerated(String shipper, String securityInfo, double netWeight, double grossWeight,
                        String typeOfCargo, double maxWeightForCargo, double maxTemperature, boolean remoteMonitored) {
        super(shipper, securityInfo, netWeight, grossWeight, typeOfCargo, maxWeightForCargo);
        this.maxTemperature = maxTemperature;
        this.remoteMonitored = remoteMonitored;
    }

    public boolean isRemoteMonitored() {
        return remoteMonitored;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public boolean requiresElectricalConnection() {
        return true;
    }
}
