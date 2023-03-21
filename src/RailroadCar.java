import java.util.ArrayList;
import java.util.Scanner;

public class RailroadCar {
    private static final Scanner scan = new Scanner(System.in);
    private static final ArrayList<RailroadCar> railroadCars = new ArrayList<>();
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

    public static void createRailroadCar() {
        System.out.print("Enter the shipper: ");
        String shipper = scan.next();
        System.out.print("Enter the security info: ");
        String securityInfo = scan.next();
        System.out.print("Enter the net weight: ");
        double netWeight = scan.nextDouble();
        System.out.print("Enter the gross weight: ");
        double grossWeight = scan.nextDouble();
        System.out.print("Enter the number of seats: ");
        int numberOfSeats = scan.nextInt();

        Passenger passenger = new Passenger(shipper, securityInfo, netWeight, grossWeight, numberOfSeats);
        railroadCars.add(passenger);
    }

    public static void print() {
        for (RailroadCar car : railroadCars) {
            System.out.println(car);
        }
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
