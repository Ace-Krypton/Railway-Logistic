import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class RailroadCar {
    private static final Scanner scan = new Scanner(System.in);
    private static final ArrayList<RailroadCar> railroadCars = new ArrayList<>();
    private static int id = -1;
    public int ID;
    private String type;
    private String shipper;
    private String securityInfo;
    private double netWeight;
    private double grossWeight;

    public RailroadCar() {
        ++id;
        ID = id;
    }

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

    public void createRailroadCar() {
        System.out.print("Enter the type: ");
        String type = scan.next();
        System.out.print("Enter the shipper: ");
        String shipper = scan.next();
        System.out.print("Enter the security info: ");
        String securityInfo = scan.next();
        System.out.print("Enter the net weight: ");
        double netWeight = scan.nextDouble();
        System.out.print("Enter the gross weight: ");
        double grossWeight = scan.nextDouble();

        switch (type.toLowerCase(Locale.ROOT)) {
            case "passenger" -> {
                System.out.print("Enter the number of seats: ");
                int numberOfSeats = scan.nextInt();
                Passenger passenger = new Passenger(shipper, securityInfo, netWeight, grossWeight, numberOfSeats);
                railroadCars.add(passenger);
            }

            case "post office" -> {

            }

            default -> {
                RailroadCar railroadCar = new RailroadCar(type, shipper, securityInfo, netWeight, grossWeight);
                railroadCars.add(railroadCar);
            }
        }
    }

    public static void print() {
        for (RailroadCar car : railroadCars) {
            System.out.println(car);
        }
    }

    @Override
    public String toString() {
        if (this instanceof Passenger passenger) {
            return ID + ". "
                    + "Type: " + getType()
                    + "\nShipper: " + getShipper()
                    + "\nSecurity Info: " + getSecurityInfo()
                    + "\nNet Weight: " + getNetWeight()
                    + "\nGross Weight: " + getGrossWeight()
                    + "\nNumber of Seats: " + passenger.getNumSeats()
                    + "\nRequires Electrical Connection: " + passenger.requiresElectricalConnection();
        } else {
            return ID + ". "
                    + "Type: " + getType()
                    + "\nShipper: " + getShipper()
                    + "\nSecurity Info: " + getSecurityInfo()
                    + "\nNet Weight: " + getNetWeight()
                    + "\nGross Weight: " + getGrossWeight();
        }
    }
}
