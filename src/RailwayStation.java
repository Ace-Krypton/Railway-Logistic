import java.util.ArrayList;
import java.util.Scanner;

public class RailwayStation {
    public ArrayList<Locomotive> locomotives = new ArrayList<>();
    private String name;
    private String location;
    private final Scanner scan = new Scanner(System.in);
    private String inputStr;
    private static int id = -1;
    int ID;

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
        if (holder.stations.isEmpty()) {
            System.out.println("Please, first create the Railway Station");
            return;
        }

        int inputInt;
        boolean loop = true;
        System.out.print("Enter the name of the locomotive: ");
        inputStr = scan.next();
        locomotiveObjs.setName(inputStr);

        System.out.println("Choose the home railway station: ");
        for (RailwayStation station : holder.stations) {
            System.out.println(station);

            System.out.print("> ");
            inputInt = scan.nextInt();

            while (loop) {
                if (inputInt != station.ID) {
                    System.out.println("Please, enter the ID correctly");
                    System.out.print("> ");
                    inputInt = scan.nextInt();
                } else loop = false;
            }
            System.out.println(station.getName() + " added");
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

        holder.stations.add(stationObj);
    }

    public String toString() {
        return ID + ". "
                + "Name: " + getName()
                + "\nLocation: " + getLocation();
    }
}
