import java.util.Locale;
import java.util.Scanner;

public class Presentation {
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
    ended at 8:38
    Sixth Day of the project
    started at 4:24
    ended at 7:22
    Seventh Day of the project
    started at 4:12
    ended at 7:32
    Eight Day of the project
    started at 5:21
    ended at ?
    */
    static RailwayStation station = new RailwayStation();
    static Locomotive locomotive = new Locomotive();
    static RailroadCar railroadCar = new RailroadCar();
    static Trainset trainset = new Trainset();
    static Route route = new Route();

    public static void main(String[] args) {
        String input;
        boolean loop = true;
        Scanner scan = new Scanner(System.in);

        while (loop) {
            menu();
            System.out.print("> ");
            input = scan.next();

            switch(input.toLowerCase(Locale.ROOT)) {
                case "1" -> station.createStations(new RailwayStation());

                case "2" -> RailwayStation.printStations();

                case "3" -> {
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

                case "4" -> Locomotive.printLocomotives();

                case "5" -> {
                    if (Locomotive.locomotives.isEmpty() || RailroadCar.railroadCars.isEmpty()) {
                        System.out.println(
                                "You need to have at least 1 locomotive and 1 railroad car\n" +
                                        "You only have " + (long) Locomotive.locomotives.size() +
                                        " locomotive(s) and " + (long) RailroadCar.railroadCars.size() +
                                        " railroad car(s)" +
                                        ", create locomotive(s) with option number [2] and railroad car(s) with option " +
                                        "number [3]\n"
                        );
                        break;
                    }
                    trainset.createTrainsets(new Trainset());
                }

                case "6" -> Trainset.printTrainsets();

                case "7" -> {
                    if (Trainset.trainsets.isEmpty()) {
                        System.out.println("You need to have at least 1 trainset");
                        break;
                    }
                    route.generate(new Route());
                }

                case "0" -> {
                    System.out.println("exiting...");
                    loop = false;
                }

                default -> System.out.println("Please, choose correct number\n");
            }
        }
    }

    public static void menu() {
        System.out.println("[1] Create Railway Station");
        System.out.println("[2] Print Railway Stations");
        System.out.println("[3] Create Locomotive");
        System.out.println("[2] Print Locomotives");
        System.out.println("[3] Create Railroad Cars");
        System.out.println("[4] Print Railroad Cars");
        System.out.println("[5] Create Trainset");
        System.out.println("[6] Print Trainsets");
        System.out.println("[7] Create Routes\n");
        System.out.println("[0] Exit");
    }
}
