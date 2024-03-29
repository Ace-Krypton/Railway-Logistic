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
        if (RailwayStation.stations.isEmpty()) {
            System.out.println("You don't have any Railway Stations\n");
            return;
        }

        System.out.println("---------------- Railway Stations ----------------");
        for (RailwayStation station : stations) {
            System.out.println(station);
        }
        System.out.println();
    }

    public void createStations(RailwayStation stationObj) {
        System.out.println("---------------- Creating the Railways ----------------");
        System.out.print("Enter the name of the station: ");
        String inputStr = scan.next();
        stationObj.setName(inputStr);

        System.out.print("Enter the location of the station: ");
        inputStr = scan.next();
        stationObj.setLocation(inputStr);

        System.out.println("[ " + stationObj.getName() + " added successfully to the Railway Stations" + " ]\n");
        stations.add(stationObj);
    }

    @Override
    public String toString() {
        return ID + ". "
                + "Name: " + getName()
                + "\nLocation: " + getLocation();
    }
}
