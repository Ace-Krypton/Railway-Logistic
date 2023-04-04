import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Locomotive {
    private final Scanner scan = new Scanner(System.in);
    public static final ArrayList<Locomotive> locomotives = new ArrayList<>();
    private double speed = 10;
    private String name;
    private RailwayStation home;
    private RailwayStation source;
    private RailwayStation destination;
    private int maxRailroadCars;
    private double maxWeight;
    private int maxElectricalGrid;
    private static int id = -1;
    public int ID;

    public Locomotive() {
        ++id;
        ID = id;
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(this::updateSpeed, 0, 1, TimeUnit.SECONDS);
    }

    public int getMaxRailroadCars() {
        return maxRailroadCars;
    }

    public void setMaxRailroadCars(int maxRailroadCars) {
        this.maxRailroadCars = maxRailroadCars;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setMaxElectricalGrid(int maxElectricalGrid) {
        this.maxElectricalGrid = maxElectricalGrid;
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
        if (Locomotive.locomotives.isEmpty()) {
            System.out.println("You don't have any Locomotives\n");
            return;
        }

        System.out.println("---------------- Locomotives ----------------");
        for (Locomotive locomotive : locomotives) {
            System.out.println(locomotive);
        }
        System.out.println();
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

        try {
            System.out.print("Enter the maximum number of railroad cars: ");
            inputInt = scan.nextInt();
            locomotiveObjs.setMaxRailroadCars(inputInt);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
            scan.next();
        }

        try {
            System.out.print("Enter the maximum weight for transported load: ");
            double maxWeight;
            maxWeight = scan.nextDouble();
            locomotiveObjs.setMaxWeight(maxWeight);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a double.");
            scan.next();
        }

        try {
            System.out.print("Enter the maximum number of railroad cars that need to be connected to the electricity grid: ");
            inputInt = scan.nextInt();
            locomotiveObjs.setMaxElectricalGrid(inputInt);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
            scan.next();
        }

        System.out.println("Choose the home railway station: [Enter the ID number]");
        RailwayStation.printStations();

        System.out.print("> ");
        inputInt = scan.nextInt();

        while (homeLoop) {
            try {
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
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scan.next();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid ID. Please enter a valid ID.");
                scan.next();
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
                try {
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
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    scan.next();
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid ID. Please enter a valid ID.");
                    scan.next();
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
            try {
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
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scan.next();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Invalid ID. Please enter a valid ID.");
                scan.next();
            }
        }

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
