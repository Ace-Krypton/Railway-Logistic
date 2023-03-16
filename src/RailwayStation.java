import java.util.ArrayList;
import java.util.Scanner;

public class RailwayStation {
    public ArrayList<RailwayStation> stations = new ArrayList<>();
    public ArrayList<Locomotive> locomotives = new ArrayList<>();
    private String name;
    private String location;
    private final Scanner scan = new Scanner(System.in);
    private String input;

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void createLocomotives(Locomotive locomotiveObjs) {
        if (stations.isEmpty()) {
            System.out.println("Please, first create the Railway Station");
            return;
        }

        System.out.print("Enter the name of the locomotive: ");
        input = scan.next();
        locomotiveObjs.setName(input);

        System.out.println("Choose the home railway station: ");
        for (RailwayStation station : stations) {

        }

        locomotives.add(locomotiveObjs);
    }

    public void createStations(RailwayStation stationObj) {
        System.out.print("Enter the name of the station: ");
        input = scan.next();
        stationObj.setName(input);

        System.out.print("Enter the location of the station: ");
        input = scan.next();
        stationObj.setLocation(input);

        stations.add(stationObj);
    }

    public String toString() {
        return
    }
}
