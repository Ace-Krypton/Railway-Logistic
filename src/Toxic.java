public class Toxic extends HeavyFreight {
    private final int hazardousRating;
    private final boolean doesHaveAirFilterationSystem;

    public Toxic(String shipper, String securityInfo, double netWeight,
                 double grossWeight, String typeOfCargo, double maxWeightForCargo,
                 int hazardousRating, boolean doesHaveAirFiltrationSystem) {
        super(shipper, securityInfo, netWeight, grossWeight, typeOfCargo, maxWeightForCargo);
        this.hazardousRating = hazardousRating;
        this.doesHaveAirFilterationSystem = doesHaveAirFiltrationSystem;
    }

    public int getHazardousRating() {
        return hazardousRating;
    }

    public boolean doesHaveAirFilterationSystem() {
        return doesHaveAirFilterationSystem;
    }
}
