public class Refrigerated extends BasicFreight {

    public Refrigerated(String shipper, String securityInfo, double netWeight, double grossWeight,
                        String typeOfCargo, double maxWeightForCargo) {
        super(shipper, securityInfo, netWeight, grossWeight, typeOfCargo, maxWeightForCargo);
    }

    public boolean requiresElectricalConnection() {
        return true;
    }
}
