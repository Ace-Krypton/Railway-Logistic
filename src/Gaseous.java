public class Gaseous extends BasicFreight {
    private final double pressureRating;
    private final boolean gasDetectionSystem;

    public Gaseous(String shipper, String securityInfo, double netWeight,
                   double grossWeight, String typeOfCargo, double maxWeightForCargo,
                   double pressureRating, boolean gasDetectionSystem) {
        super(shipper, securityInfo, netWeight, grossWeight, typeOfCargo, maxWeightForCargo);
        this.pressureRating = pressureRating;
        this.gasDetectionSystem = gasDetectionSystem;
    }

    public boolean doesHaveGasDetectionSystem() {
        return gasDetectionSystem;
    }

    public double getPressureRating() {
        return pressureRating;
    }
}
