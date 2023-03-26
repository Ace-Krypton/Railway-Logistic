public class LiquidToxic extends HeavyFreight implements ILiquidate {
    private final boolean isFlamable;
    private final double phLevel;

    public LiquidToxic(String shipper, String securityInfo, double netWeight,
                       double grossWeight, String typeOfCargo, double maxWeightForCargo,
                       boolean isFlamable, double phLevel) {
        super(shipper, securityInfo, netWeight, grossWeight, typeOfCargo, maxWeightForCargo);
        this.isFlamable = isFlamable;
        this.phLevel = phLevel;
    }

    @Override
    public double getPHLevel() {
        return phLevel;
    }

    @Override
    public boolean flammability() {
        return isFlamable;
    }
}
