import java.util.ArrayList;
import java.util.Scanner;

public class Locomotive {
    private final Scanner scan = new Scanner(System.in);
    public static final ArrayList<Locomotive> locomotives = new ArrayList<>();
    private double speed = 100;
    private String name;
    private RailwayStation home;
    private int maxRailroadCars;
    private double maxWeight;
    private int maxElectricalGrid;

    public void setMaxRailroadCars(int maxRailroadCars) {
        this.maxRailroadCars = maxRailroadCars;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setMaxElectricalGrid(int maxElectricalGrid) {
        this.maxElectricalGrid = maxElectricalGrid;
    }

    private RailwayStation source;
    private RailwayStation destination;
    private static int id = -1;
    public int ID;

    public Locomotive() {
        ++id;
        ID = id;
    }

    public int getMaxRailroadCars() {
        return maxRailroadCars;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public int getMaxElectricalGrid() {
        return maxElectricalGrid;
    }

    public double getSpeed() {
        return this.speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RailwayStation getHome() {
        return home;
    }

    public void setHome(RailwayStation home) {
        this.home = home;
    }

    public RailwayStation getSource() {
        return source;
    }

    public void setSource(RailwayStation source) {
        this.source = source;
    }

    public RailwayStation getDestination() {
        return destination;
    }

    public void setDestination(RailwayStation destination) {
        this.destination = destination;
    }

    public static void printLocomotives() {
        for (Locomotive locomotive : locomotives) {
            System.out.println(locomotive);
        }
    }

    public void updateSpeed() {
        double change = this.speed * 0.03 * (Math.random() > 0.5 ? 1 : -1);
        this.speed += change;
    }

    public void createLocomotives(Locomotive locomotiveObjs) {
        int inputInt;
        boolean homeLoop = true;
        boolean foundHomeStation = false;

        System.out.print("Enter the name of the locomotive: ");
        String inputStr = scan.next();
        locomotiveObjs.setName(inputStr);

        System.out.print("Enter the maximum number of railroad cars: ");
        inputInt = scan.nextInt();
        locomotiveObjs.setMaxRailroadCars(inputInt);

        System.out.print("Enter the maximum weight for transported load: ");
        double maxWeight;
        maxWeight = scan.nextDouble();
        locomotiveObjs.setMaxWeight(maxWeight);

        System.out.print("Enter the maximum number of railroad cars that need to be connected to the electricity grid: ");
        inputInt = scan.nextInt();
        locomotiveObjs.setMaxElectricalGrid(inputInt);

        System.out.println("Choose the home railway station: [Enter the ID number]");
        RailwayStation.printStations();

        System.out.print("> ");
        inputInt = scan.nextInt();

        while (homeLoop) {
            for (RailwayStation station : RailwayStation.stations) {
                if (inputInt == station.ID) {
                    foundHomeStation = true;
                    locomotiveObjs.setHome(station);
                    RailwayStation.stations.remove(station);
                    System.out.println(station.getName() + " added successfully to the Locomotive\n");
                    break;
                }
            } if (foundHomeStation) {
                homeLoop = false;
            } else {
                System.out.println("Please, enter the ID correctly");
                System.out.print("> ");
                inputInt = scan.nextInt();
            }
        }

        System.out.println("Is your source railway station same with home?\n" +
                "if \"yes\" input \"y\" if \"no\" input \"N\"");

        System.out.print("y/N > ");
        inputStr = scan.next();

        if (inputStr.equalsIgnoreCase("N")) {
            System.out.println("Choose the source railway station: [Enter the ID number]");
            RailwayStation.printStations();

            System.out.print("> ");
            inputInt = scan.nextInt();

            boolean sourceLoop = true;
            boolean foundSourceStation = false;

            while (sourceLoop) {
                for (RailwayStation station : RailwayStation.stations) {
                    if (inputInt == station.ID) {
                        foundSourceStation = true;
                        locomotiveObjs.setSource(station);
                        RailwayStation.stations.remove(station);
                        System.out.println(station.getName() + " added successfully to the Locomotive\n");
                        break;
                    }
                } if (foundSourceStation) {
                    sourceLoop = false;
                } else {
                    System.out.println("Please, enter the ID correctly");
                    System.out.print("> ");
                    inputInt = scan.nextInt();
                }
            }
        }
        System.out.println("Choose the destination railway station: [Enter the ID number]");
        RailwayStation.printStations();

        System.out.print("> ");
        inputInt = scan.nextInt();

        boolean destinationLoop = true;
        boolean foundDestinationStation = false;

        while (destinationLoop) {
            for (RailwayStation station : RailwayStation.stations) {
                if (inputInt == station.ID) {
                    foundDestinationStation = true;
                    locomotiveObjs.setDestination(station);
                    RailwayStation.stations.remove(station);
                    System.out.println(station.getName() + " added successfully to the Locomotive\n");
                    break;
                }
            } if (foundDestinationStation) {
                destinationLoop = false;
            } else {
                System.out.println("Please, enter the ID correctly");
                System.out.print("> ");
                inputInt = scan.nextInt();
            }
        }

        System.out.println(locomotiveObjs + " added successfully to the Locomotives\n");
        locomotives.add(locomotiveObjs);
    }

    @Override
    public String toString() {
        return ID + ". "
                + "Name: " + getName()
                + "\nHome: " + getHome().getName()
                + "\nSource: " + getSource().getName()
                + "\nDestination: " + getDestination().getName()
                + "\nMaximum Railroad Cars: " + getMaxRailroadCars()
                + "\nMaximum Weight: " + getMaxWeight()
                + "\nMaximum Railroad Cars with Electrical Grid: " + getMaxElectricalGrid();
    }
}
