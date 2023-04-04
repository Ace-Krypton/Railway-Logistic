import java.util.*;

public class Presentation {
    static RailwayStation station = new RailwayStation();
    static Locomotive locomotive = new Locomotive();
    static RailroadCar railroadCar = new RailroadCar();
    static Trainset trainset = new Trainset();
    static Route route = new Route();

    public static void main(String[] args) {
        Hashtable<String, String> userPass = new Hashtable<>();
        String input;
        boolean loop = true;
        boolean login = true;
        Scanner scan = new Scanner(System.in);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Trainset.updateAppState();
            }
        }, 0, 5000);

        while (login) {
            main_menu();
            System.out.print("> ");
            input = scan.next();

            switch (input.toLowerCase(Locale.ROOT)) {
                case "1" -> {
                    System.out.println("-------------------- LOGIN --------------------");
                    System.out.print("Please enter the username: ");
                    String username = scan.next();
                    System.out.print("Please enter the password: ");
                    String password = scan.next();

                    if (!userPass.containsKey(password) || !userPass.containsValue(username)) {
                        String ANSI_RED = "\u001B[31m";
                        String ANSI_RESET = "\u001B[0m";
                        System.out.println('\n' + ANSI_RED + "Authentication Revoked!" + ANSI_RESET);
                    } else {
                        System.out.println("\nAuthentication Successful!");
                        System.out.println("-----------------------------------------------\n");
                        login = false;

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

                                case "5" -> railroadCar.createRailroadCar();

                                case "6" -> RailroadCar.printRailroadCars();

                                case "7" -> {
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

                                case "8" -> Trainset.printTrainsets();

                                case "9" -> {
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
                }

                case "2" -> {
                    System.out.println("-------------------- REGISTER --------------------");
                    String username;
                    do {
                        System.out.print("\nUsername: ");
                        username = scan.next();
                    }
                    while (userPass.containsValue(username));
                    System.out.print("Password: ");
                    String password = scan.next();
                    userPass.put(password, username);
                    System.out.println("\nAccount Created Successfully!");
                    System.out.println("--------------------------------------------------");
                }

                case "0" -> {
                    System.out.println("exiting...");
                    login = false;
                }
            }
        }

        timer.cancel();
        System.exit(0);
    }

    public static void main_menu() {
        System.out.println("[1] Login");
        System.out.println("[2] Register\n");
        System.out.println("[0] Exit");
    }

    public static void menu() {
        System.out.println("[1] Create Railway Station");
        System.out.println("[2] Print Railway Stations");
        System.out.println("[3] Create Locomotive");
        System.out.println("[4] Print Locomotives");
        System.out.println("[5] Create Railroad Cars");
        System.out.println("[6] Print Railroad Cars");
        System.out.println("[7] Create Trainset");
        System.out.println("[8] Print Trainsets");
        System.out.println("[9] Create Routes\n");
        System.out.println("[0] Exit");
    }
}
