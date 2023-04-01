public class HeavyFreight extends RailroadCar {
    private final String typeOfCargo;
    private final double maxWeightForCargo;

    public HeavyFreight(String shipper, String securityInfo, double netWeight,
                        double grossWeight, String typeOfCargo, double maxWeightForCargo) {
        super("Heavy Freight", shipper, securityInfo, netWeight, grossWeight, false);
        this.typeOfCargo = typeOfCargo;
        this.maxWeightForCargo = maxWeightForCargo;
    }

    public double getMaxWeightForCargo() {
        return maxWeightForCargo;
    }

    public String getTypeOfCargo() {
        return typeOfCargo;
    }

    public boolean requiresElectricalConnection() {
        return false;
    }
}
