public class Restaurant extends RailroadCar {
    private final int numChairsAndTables;
    private final String typeOfCuisine;

    public Restaurant(String shipper, String securityInfo, double netWeight, double grossWeight,
                      int numChairsAndTables, String typeOfCuisine) {
        super("Restaurant", shipper, securityInfo, netWeight, grossWeight, false);
        this.numChairsAndTables = numChairsAndTables;
        this.typeOfCuisine = typeOfCuisine;
    }

    public String getTypeOfCuisine() {
        return typeOfCuisine;
    }

    public int getNumChairsAndTables() {
        return numChairsAndTables;
    }

    public boolean requiresElectricalConnection() {
        return false;
    }
}
