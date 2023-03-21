import java.util.ArrayList;

public class RailroadCar {
    private static final ArrayList<RailroadCar> railroads = new ArrayList<>();
    private static int id;
    public int ID;
    private final String type;
    private final String shipper;
    private final String securityInfo;
    private final double netWeight;
    private final double grossWeight;

    public RailroadCar(String type, String shipper, String securityInfo, double netWeight, double grossWeight) {
        ++id;
        ID = id;
        this.type = type;
        this.shipper = shipper;
        this.securityInfo = securityInfo;
        this.netWeight = netWeight;
        this.grossWeight = grossWeight;
    }

    public String getType() {
        return type;
    }

    public String getShipper() {
        return shipper;
    }

    public String getSecurityInfo() {
        return securityInfo;
    }

    public double getNetWeight() {
        return netWeight;
    }

    public double getGrossWeight() {
        return grossWeight;
    }

    @Override
    public String toString() {
        return ID + ". "
                + "Type: " + getType()
                + "Shipper: " + getShipper()
                + "Security Info: " + getSecurityInfo()
                + "Net Weight: " + getNetWeight()
                + "Gross Weight: " + getGrossWeight();
    }
}
