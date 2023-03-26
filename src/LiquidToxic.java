public class LiquidToxic extends HeavyFreight implements ILiquidate {
    private final boolean isFlamable;
    private final double phLevel;
    private final String packagingType;

    public LiquidToxic(String shipper, String securityInfo, double netWeight,
                       double grossWeight, String typeOfCargo, double maxWeightForCargo,
                       boolean isFlamable, double phLevel, String packagingType) {
        super(shipper, securityInfo, netWeight, grossWeight, typeOfCargo, maxWeightForCargo);
        this.isFlamable = isFlamable;
        this.phLevel = phLevel;
        this.packagingType = packagingType;
    }

    public String getPackagingType() {
        return packagingType;
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
