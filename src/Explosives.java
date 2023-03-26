public class Explosives extends HeavyFreight {
    private final int sensitivity;
    private final double blastRadius;

    public Explosives(String shipper, String securityInfo, double netWeight,
                      double grossWeight, String typeOfCargo, double maxWeightForCargo,
                      int sensitivity, double blastRadius) {
        super(shipper, securityInfo, netWeight, grossWeight, typeOfCargo, maxWeightForCargo);
        this.sensitivity = sensitivity;
        this.blastRadius = blastRadius;
    }

    public int getSensitivity() {
        return sensitivity;
    }

    public double getBlastRadius() {
        return blastRadius;
    }
}
