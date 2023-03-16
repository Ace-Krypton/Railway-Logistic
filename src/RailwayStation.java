import java.util.Scanner;

public class RailwayStation {
    private String name;
    private String location;
    private final Scanner scan = new Scanner(System.in);
    private String input;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void createLocomotives(Locomotive locomotiveObjs) {
        System.out.print("Enter the name of the locomotive: ");
        input = scan.next();
        locomotiveObjs.setName(input);

        System.out.println("Choose the home railway station: ");

    }

    public void createStations(RailwayStation stationObj) {
        System.out.print("Enter the name of the station: ");
        input = scan.next();
        stationObj.setName(input);

        System.out.print("Enter the location of the station: ");
        input = scan.next();
        stationObj.setLocation(input);
    }
}
