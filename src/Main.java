import java.util.Locale;
import java.util.Scanner;

public class Main {
    /*
    NOTES
    First Day of the project:
    started at 8:30
    ended at 9:40
    Second Day of the project:
    started at 5:40
    ended at 8:04
    Third Day of the project
    started at 6:38
    ended at 9:29
    Fourth Day of the project:
    started at 4:13
    ended at 8:00
    Fifth Day of the project:
    started at 6:20
    ended at ?
    */
    static RailwayStation station = new RailwayStation();
    static Locomotive locomotive = new Locomotive();
    static RailroadCar railroadCar = new RailroadCar();

    public static void main(String[] args) {
        String input;
        boolean loop = true;
        Scanner scan = new Scanner(System.in);

        while (loop) {
            menu();
            System.out.print("> ");
            input = scan.next();

            switch(input.toLowerCase(Locale.ROOT)) {
                case "test" -> RailroadCar.print();
                case "1" -> station.createStations(new RailwayStation());
                case "2" -> {
                    if (RailwayStation.stations.isEmpty() || (long) RailwayStation.stations.size() < 3) {
                        System.out.println(
                                "You need to have at least 3 stations in the Railway\n" +
                                        "You only have " + (long) RailwayStation.stations.size() +
                                        ", create stations with option number [1]\n"
                        );
                        break;
                    }
                    locomotive.createLocomotives(new Locomotive());
                }
                case "3" -> railroadCar.createRailroadCar();
                case "0" -> {
                    System.out.println("exiting...");
                    loop = false;
                }
                default -> System.out.println("Please, choose correct number\n");
            }
        }
    }

    private static void menu() {
        System.out.println("[1] Create Railway Station");
        System.out.println("[2] Create Locomotive");
        System.out.println("[3] Create Railroad Cars");
        System.out.println("[0] Exit");
    }
}
