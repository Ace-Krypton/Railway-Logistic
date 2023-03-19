import java.util.ArrayList;
import java.util.Scanner;

public class RailwayStation {
    private static final ArrayList<RailwayStation> stations = new ArrayList<>();
    public ArrayList<Locomotive> locomotives = new ArrayList<>();
    private String name;
    private String location;
    private final Scanner scan = new Scanner(System.in);
    private String inputStr;
    private static int id = -1;
    public int ID;

    public RailwayStation() {
        ++id;
        ID = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void createLocomotives(Locomotive locomotiveObjs) {
        if (stations.isEmpty() || (long) stations.size() < 2) {
            System.out.println(
                    "You need to have at least 2 stations in the Railway\n" +
                    "You only have " + (long) stations.size() +
                    ", create stations with option number [1]\n"
            );
            return;
        }

        int inputInt;
        boolean loop = true;
        boolean foundHomeStation = false;

        System.out.print("Enter the name of the locomotive: ");
        inputStr = scan.next();
        locomotiveObjs.setName(inputStr);

        System.out.println("Choose the home railway station: ");
        for (RailwayStation station : stations) {
            System.out.println(station);
        }

        System.out.print("> ");
        inputInt = scan.nextInt();

        while (loop) {
            for (RailwayStation station : stations) {
                if (inputInt == station.ID) {
                    foundHomeStation = true;
                    locomotiveObjs.setHome(station);
                    stations.remove(station);
                    System.out.println(station.getName() + " added successfully to the Locomotive\n");
                    break;
                }
            } if (foundHomeStation) {
                loop = false;
            } else {
                System.out.println("Please, enter the ID correctly");
                System.out.print("> ");
                inputInt = scan.nextInt();
            }
        }

        System.out.println("Choose the source railway station: ");
        for (RailwayStation station : stations) {
            System.out.println(station);
        }

        System.out.print("> ");
        inputInt = scan.nextInt();

        boolean sourceLoop = true;
        boolean foundSourceStation = false;

        while (sourceLoop) {
            for (RailwayStation station : stations) {
                if (inputInt == station.ID) {
                    foundSourceStation = true;
                    locomotiveObjs.setSource(station);
                    stations.remove(station);
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

        locomotives.add(locomotiveObjs);
    }

    public void createStations(RailwayStation stationObj) {
        System.out.print("Enter the name of the station: ");
        inputStr = scan.next();
        stationObj.setName(inputStr);

        System.out.print("Enter the location of the station: ");
        inputStr = scan.next();
        stationObj.setLocation(inputStr);

        System.out.println(inputStr + " added successfully to the Railway Stations\n");
        stations.add(stationObj);
    }

    public String toString() {
        return ID + ". "
                + "Name: " + getName()
                + "\nLocation: " + getLocation();
    }
}
