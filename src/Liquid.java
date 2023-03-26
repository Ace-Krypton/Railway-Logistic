public class Liquid extends BasicFreight implements ILiquidate {
    public Liquid(String shipper, String securityInfo, double netWeight,
                  double grossWeight, String typeOfCargo, double maxWeightForCargo) {
        super(shipper, securityInfo, netWeight, grossWeight, typeOfCargo, maxWeightForCargo);
    }

    @Override
    public double getPHLevel() {
        return 0;
    }

    @Override
    public boolean flammability() {
        return false;
    }
}
