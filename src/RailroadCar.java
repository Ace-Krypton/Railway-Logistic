import java.util.ArrayList;
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
        System.out.println("""
                [1] Passenger
                [2] Post Office
                [3] Restaurant
                [4] Baggage and Mail
                [5] Basic Freight
                [6] Heavy Freight
                [7] Default Railroad Car
                """);
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

        switch (type) {
            case "1" -> {
                System.out.print("Enter the number of seats: ");
                int numberOfSeats = scan.nextInt();
                System.out.print("Enter the number of luggage racks: ");
                int numberOfLuggageRacks = scan.nextInt();
                System.out.println("""
                        [1] Reclining seats
                        [2] Ergonomic seats
                        [3] Sleeper seats
                        [4] Bench seats""");
                System.out.print("Choose the type of the seat: ");
                String typeOfSeatInput = scan.next();
                String typeOfSeat = "Reclining";

                switch (typeOfSeatInput) {
                    case "1" -> typeOfSeat = "Reclining";
                    case "2" -> typeOfSeat = "Ergonomic";
                    case "3" -> typeOfSeat = "Sleeper";
                    case "4" -> typeOfSeat = "Bench";
                }

                Passenger passenger = new Passenger(shipper, securityInfo,
                        netWeight, grossWeight, numberOfSeats, numberOfLuggageRacks, typeOfSeat);
                railroadCars.add(passenger);
                System.out.println("Passenger added successfully to the railroad cars");
            }

            case "2" -> {
                System.out.print("Enter the number of mail slots: ");
                int numOfMailSlots = scan.nextInt();
                System.out.print("Enter the maximum weight capacity for mail: ");
                double maxWeightForMail = scan.nextDouble();
                PostOffice postOffice = new PostOffice(shipper, securityInfo, netWeight, grossWeight,
                        numOfMailSlots, maxWeightForMail);
                railroadCars.add(postOffice);
                System.out.println("Post Office added successfully to the railroad cars");
            }

            case "3" -> {
                System.out.print("Enter the number of tables and chairs: ");
                int numChairsAndTables = scan.nextInt();
                System.out.println("""
                        [1] American cuisine
                        [2] European cuisine
                        [3] Asian cuisine
                        [4] Vegetarian/vegan cuisine
                        [5] Local cuisine (Depending the route and destination)
                        [6] Fine dining""");

                System.out.print("Enter the type of cuisine served: ");
                String typeOfCuisineInput = scan.next();
                String typeOfCuisine = "Local cuisine";

                switch (typeOfCuisineInput) {
                    case "1" -> typeOfCuisine = "American";
                    case "2" -> typeOfCuisine = "European";
                    case "3" -> typeOfCuisine = "Asian";
                    case "4" -> typeOfCuisine = "Vegetarian/vegan";
                    case "5" -> typeOfCuisine = "Local cuisine";
                    case "6" -> typeOfCuisine = "Fine dining";
                }

                Restaurant restaurant = new Restaurant(shipper, securityInfo, netWeight, grossWeight,
                        numChairsAndTables, typeOfCuisine);
                railroadCars.add(restaurant);
                System.out.println("Restaurant added successfully to the railroad cars");
            }

            case "4" -> {
                System.out.print("Enter the maximum number of compartments: ");
                int maxCompartment = scan.nextInt();
                System.out.print("Enter the maximum weight capacity: ");
                double maxWeightCapacity = scan.nextDouble();
                BaggageAndMail baggageAndMail = new BaggageAndMail(shipper, securityInfo, netWeight,
                        grossWeight, maxCompartment, maxWeightCapacity);
                railroadCars.add(baggageAndMail);
                System.out.println("Baggage and Mail added successfully to the railroad cars");
            }

            case "5" -> {
                System.out.print("Enter the maximum weight capacity for cargo: ");
                double maxWeightForCargo = scan.nextDouble();

                System.out.println("""
                        [1] Bulk goods
                        [2] Packaged goods
                        [3] Building materials
                        [4] Refrigerated
                        [5] Liquid
                        [6] Gaseous""");
                System.out.print("Enter the type of cargo: ");
                String typeOfCargoInput = scan.next();
                String typeOfCargo = "Packaged goods";

                switch (typeOfCargoInput) {
                    case "1" -> typeOfCargo = "Bulk goods";
                    case "2" -> typeOfCargo = "Packaged goods";
                    case "3" -> typeOfCargo = "Building materials";

                    case "4" -> {
                        System.out.print("Enter the maximum temperature for refrigerator: ");
                        double maxTemperature = scan.nextDouble();

                        System.out.println("Does the car remote monitored?\n" +
                                "if \"yes\" input \"y\" if \"no\" input \"N\"");
                        System.out.print("y/N > ");
                        String input = scan.next();
                        boolean remoteMonitored = input.equalsIgnoreCase("Y");

                        Refrigerated refrigerated = new Refrigerated(shipper, securityInfo, netWeight, grossWeight,
                                typeOfCargo, maxWeightForCargo, maxTemperature, remoteMonitored);
                        railroadCars.add(refrigerated);
                        System.out.println("Refrigerated added successfully to the railroad cars");
                        return;
                    }

                    case "5" -> {
                        Liquid liquid = new Liquid(shipper, securityInfo, netWeight, grossWeight,
                                typeOfCargo, maxWeightForCargo);
                        railroadCars.add(liquid);
                        System.out.println("Liquid added successfully to the railroad cars");
                        return;
                    }

                    case "6" -> {
                        Gaseous gaseous = new Gaseous(shipper, securityInfo, netWeight, grossWeight,
                                typeOfCargo, maxWeightForCargo);
                        railroadCars.add(gaseous);
                        System.out.println("Gaseous added successfully to the railroad cars");
                        return;
                    }
                }

                BasicFreight basicFreight = new BasicFreight(shipper, securityInfo, netWeight, grossWeight,
                        typeOfCargo, maxWeightForCargo);
                railroadCars.add(basicFreight);
                System.out.println("Basic Freight added successfully to the railroad cars");
            }

            case "6" -> {
                System.out.print("Enter the maximum weight capacity for cargo: ");
                double maxWeightForCargo = scan.nextDouble();

                System.out.println("""
                        [1] Heavy machinery
                        [2] Vehicles
                        [3] Raw materials
                        [4] Aerospace components
                        [5] Military equipment
                        [6] Explosives
                        [7] Toxic
                        [8] Toxic Liquid""");
                System.out.print("Enter the type of cargo: ");
                String typeOfCargoInput = scan.next();
                String typeOfCargo = "Heavy machinery";

                switch (typeOfCargoInput) {
                    case "1" -> typeOfCargo = "Heavy machinery";
                    case "2" -> typeOfCargo = "Vehicles";
                    case "3" -> typeOfCargo = "Raw materials";
                    case "4" -> typeOfCargo = "Aerospace components";
                    case "5" -> typeOfCargo = "Military equipment";

                    case "6" -> {
                        Explosives explosives = new Explosives(shipper, securityInfo, netWeight, grossWeight,
                                typeOfCargo, maxWeightForCargo);
                        railroadCars.add(explosives);
                        System.out.println("Explosives added successfully to the railroad cars");
                        return;
                    }

                    case "7" -> {
                        Toxic toxic = new Toxic(shipper, securityInfo, netWeight, grossWeight,
                                typeOfCargo, maxWeightForCargo);
                        railroadCars.add(toxic);
                        System.out.println("Toxic added successfully to the railroad cars");
                        return;
                    }

                    case "8" -> {
                        System.out.print("Enter the PH level of the liquid (Ranges between 0-14): ");
                        double phLevel = scan.nextDouble();

                        System.out.println("Does the liquid flammable?\n" +
                                "if \"yes\" input \"y\" if \"no\" input \"N\"");
                        System.out.print("y/N > ");
                        String input = scan.next();
                        boolean isFlammable = input.equalsIgnoreCase("Y");

                        LiquidToxic liquidToxic = new LiquidToxic(shipper, securityInfo, netWeight, grossWeight,
                                typeOfCargo, maxWeightForCargo, isFlammable, phLevel);
                        railroadCars.add(liquidToxic);
                        System.out.println("Liquid Toxic added successfully to the railroad cars");
                        return;
                    }
                }

                HeavyFreight heavyFreight = new HeavyFreight(shipper, securityInfo, netWeight,
                        grossWeight, typeOfCargo, maxWeightForCargo);
                railroadCars.add(heavyFreight);
                System.out.println("Heavy Freight added successfully to the railroad cars");
            }

            case "7" -> {
                RailroadCar railroadCar = new RailroadCar(type, shipper, securityInfo, netWeight, grossWeight);
                railroadCars.add(railroadCar);
                System.out.println("Standard added successfully to the railroad cars");
            }

            default -> System.out.println("Please, choose correct number\n");
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
                    + "\nNumber of Luggage Racks: " + passenger.getNumLuggageRacks()
                    + "\nType of the Seats: " + passenger.getTypeOfSeat()
                    + "\nRequires Electrical Connection: " + passenger.requiresElectricalConnection();
        } else if (this instanceof PostOffice postOffice) {
            return ID + ". "
                    + "Type: " + getType()
                    + "\nShipper: " + getShipper()
                    + "\nSecurity Info: " + getSecurityInfo()
                    + "\nNet Weight: " + getNetWeight()
                    + "\nGross Weight: " + getGrossWeight()
                    + "\nNumber of Mail Slots: " + postOffice.getNumOfMailSlots()
                    + "\nMaximum Weight Capacity for Mail: " + postOffice.getMaxWeightForMail()
                    + "\nRequires Electrical Connection: " + postOffice.requiresElectricalConnection();
        } else if (this instanceof Restaurant restaurant) {
            return ID + ". "
                    + "Type: " + getType()
                    + "\nShipper: " + getShipper()
                    + "\nSecurity Info: " + getSecurityInfo()
                    + "\nNet Weight: " + getNetWeight()
                    + "\nGross Weight: " + getGrossWeight()
                    + "\nNumber of Chairs and Tables: " + restaurant.getNumChairsAndTables()
                    + "\nType of Cuisine: " + restaurant.getTypeOfCuisine()
                    + "\nRequires Electrical Connection: " + restaurant.requiresElectricalConnection();
        } else if (this instanceof BaggageAndMail baggageAndMail) {
            return ID + ". "
                    + "Type: " + getType()
                    + "\nShipper: " + getShipper()
                    + "\nSecurity Info: " + getSecurityInfo()
                    + "\nNet Weight: " + getNetWeight()
                    + "\nGross Weight: " + getGrossWeight()
                    + "\nMaximum Number of Compartments: " + baggageAndMail.getMaxCompartment()
                    + "\nRequires Electrical Connection: " + baggageAndMail.requiresElectricalConnection();
        } else if (this instanceof BasicFreight basicFreight) {
            if (basicFreight instanceof Refrigerated refrigerated) {
                return ID + ". "
                        + "Type: " + getType()
                        + "\nShipper: " + getShipper()
                        + "\nSecurity Info: " + getSecurityInfo()
                        + "\nNet Weight: " + getNetWeight()
                        + "\nGross Weight: " + getGrossWeight()
                        + "\nType of Cargo: " + refrigerated.getTypeOfCargo()
                        + "\nMaximum Weight Capacity for Cargo: " + refrigerated.getMaxWeightForCargo()
                        + "\nMaximum Temperature Inside the Container: " + refrigerated.getMaxTemperature()
                        + "\nDoes It Being Remotely Monitored: " + refrigerated.isRemoteMonitored()
                        + "\nRequires Electrical Connection: " + refrigerated.requiresElectricalConnection();
            } else if (basicFreight instanceof Liquid liquid) {
                return ID + ". "
                        + "Type: " + getType()
                        + "\nShipper: " + getShipper()
                        + "\nSecurity Info: " + getSecurityInfo()
                        + "\nNet Weight: " + getNetWeight()
                        + "\nGross Weight: " + getGrossWeight()
                        + "\nType of Cargo: " + liquid.getTypeOfCargo()
                        + "\nMaximum Weight Capacity for Cargo: " + liquid.getMaxWeightForCargo()
                        + "\nRequires Electrical Connection: " + liquid.requiresElectricalConnection();
            } else if (basicFreight instanceof Gaseous gaseous) {
                return ID + ". "
                        + "Type: " + getType()
                        + "\nShipper: " + getShipper()
                        + "\nSecurity Info: " + getSecurityInfo()
                        + "\nNet Weight: " + getNetWeight()
                        + "\nGross Weight: " + getGrossWeight()
                        + "\nType of Cargo: " + gaseous.getTypeOfCargo()
                        + "\nMaximum Weight Capacity for Cargo: " + gaseous.getMaxWeightForCargo()
                        + "\nRequires Electrical Connection: " + gaseous.requiresElectricalConnection();
            } else {
                return ID + ". "
                        + "Type: " + getType()
                        + "\nShipper: " + getShipper()
                        + "\nSecurity Info: " + getSecurityInfo()
                        + "\nNet Weight: " + getNetWeight()
                        + "\nGross Weight: " + getGrossWeight()
                        + "\nType of Cargo: " + basicFreight.getTypeOfCargo()
                        + "\nMaximum Weight Capacity for Cargo: " + basicFreight.getMaxWeightForCargo()
                        + "\nRequires Electrical Connection: " + basicFreight.requiresElectricalConnection();
            }
        } else if (this instanceof HeavyFreight heavyFreight) {
            if (heavyFreight instanceof LiquidToxic liquidToxic) {
                return ID + ". "
                        + "Type: " + getType()
                        + "\nShipper: " + getShipper()
                        + "\nSecurity Info: " + getSecurityInfo()
                        + "\nNet Weight: " + getNetWeight()
                        + "\nGross Weight: " + getGrossWeight()
                        + "\nType of Cargo: " + liquidToxic.getTypeOfCargo()
                        + "\nMaximum Weight Capacity for Cargo: " + liquidToxic.getMaxWeightForCargo()
                        + "\nPH Level of the Liquid: " + liquidToxic.getPHLevel()
                        + "\nDoes the Liquid Flammable: " + liquidToxic.flammability()
                        + "\nRequires Electrical Connection: " + liquidToxic.requiresElectricalConnection();
            } else if (heavyFreight instanceof Toxic toxic) {
                return ID + ". "
                        + "Type: " + getType()
                        + "\nShipper: " + getShipper()
                        + "\nSecurity Info: " + getSecurityInfo()
                        + "\nNet Weight: " + getNetWeight()
                        + "\nGross Weight: " + getGrossWeight()
                        + "\nType of Cargo: " + toxic.getTypeOfCargo()
                        + "\nMaximum Weight Capacity for Cargo: " + toxic.getMaxWeightForCargo()
                        + "\nRequires Electrical Connection: " + toxic.requiresElectricalConnection();
            } else if (heavyFreight instanceof Explosives explosives) {
                return ID + ". "
                        + "Type: " + getType()
                        + "\nShipper: " + getShipper()
                        + "\nSecurity Info: " + getSecurityInfo()
                        + "\nNet Weight: " + getNetWeight()
                        + "\nGross Weight: " + getGrossWeight()
                        + "\nType of Cargo: " + explosives.getTypeOfCargo()
                        + "\nMaximum Weight Capacity for Cargo: " + explosives.getMaxWeightForCargo()
                        + "\nRequires Electrical Connection: " + explosives.requiresElectricalConnection();
            } else {
                return ID + ". "
                        + "Type: " + getType()
                        + "\nShipper: " + getShipper()
                        + "\nSecurity Info: " + getSecurityInfo()
                        + "\nNet Weight: " + getNetWeight()
                        + "\nGross Weight: " + getGrossWeight()
                        + "\nType of Cargo: " + heavyFreight.getTypeOfCargo()
                        + "\nMaximum Weight Capacity for Cargo: " + heavyFreight.getMaxWeightForCargo()
                        + "\nRequires Electrical Connection: " + heavyFreight.requiresElectricalConnection();
            }
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
