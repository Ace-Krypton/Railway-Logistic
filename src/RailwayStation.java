import java.util.ArrayList;
import java.util.Scanner;

public class RailwayStation {
    public static final ArrayList<RailwayStation> stations = new ArrayList<>();
    private String name;
    private String location;
    private final Scanner scan = new Scanner(System.in);
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

    public static void printStations() {
        for (RailwayStation station : stations) {
            System.out.println(station);
        }
    }

    public void createStations(RailwayStation stationObj) {
        System.out.print("Enter the name of the station: ");
        String inputStr = scan.next();
        stationObj.setName(inputStr);

        System.out.print("Enter the location of the station: ");
        inputStr = scan.next();
        stationObj.setLocation(inputStr);

        System.out.println("[ " + stationObj.getName() + " added successfully to the Railway Stations\n" + " ]");
        stations.add(stationObj);
    }

    public String toString() {
        return ID + ". "
                + "Name: " + getName()
                + "\nLocation: " + getLocation();
    }
}
