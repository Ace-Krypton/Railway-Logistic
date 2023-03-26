public class Liquid extends BasicFreight implements ILiquidate {
    private final double freezingPoint;
    private final boolean isFlammable;
    private final double phLevel;

    public Liquid(String shipper, String securityInfo, double netWeight,
                  double grossWeight, String typeOfCargo, double maxWeightForCargo, double freezingPoint,
                  boolean isFlammable, double phLevel) {
        super(shipper, securityInfo, netWeight, grossWeight, typeOfCargo, maxWeightForCargo);
        this.phLevel = phLevel;
        this.freezingPoint = freezingPoint;
        this.isFlammable = isFlammable;
    }

    public double getFreezingPoint() {
        return freezingPoint;
    }

    @Override
    public double getPHLevel() {
        return phLevel;
    }

    @Override
    public boolean flammability() {
        return isFlammable;
    }
}
