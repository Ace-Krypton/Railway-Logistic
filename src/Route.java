import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Route {
    public static ArrayList<Route> routes = new ArrayList<>();
    private String fromTo;
    private int distance;
    private static final Scanner scan = new Scanner(System.in);
    private static final Map<Character, Integer> distances = new HashMap<>();

    static {
        int distance = 20;
        for (char c = 'a'; c <= 'z'; c++) {
            if (distance > 200) break;
            distances.put(c, distance);
            distance += 20;
        }
    }

    public void setFromTo(String fromTo) {
        this.fromTo = fromTo;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getFromTo() {
        return fromTo;
    }

    public int getDistance() {
        return distance;
    }

    public static int distance(String s1, String s2) {
        if (s1 == null || s2 == null) {
            throw new IllegalArgumentException("Input strings cannot be null.");
        }
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        int distance = 0;
        for (int i = 0; i < s1.length() && i < s2.length(); i++) {
            distance += distances.getOrDefault(s1.charAt(i), 0) -
                    distances.getOrDefault(s2.charAt(i), 0);
            distance = Math.max(distance, 20);
            if (distance > 200) {
                distance = 200;
                break;
            }
        }
        return distance;
    }

    public void generate(Route routeObj) {
        System.out.println("---------------- Generating the Route ----------------");
        System.out.println("Choose the Trainset: [Enter the ID number]");
        Trainset.printTrainsets();

        System.out.print("> ");
        String inputTrainset = scan.next();
        boolean trainsetLoop = true;
        boolean foundTrainset = false;
        boolean trainsetOnRoute = false;

        while (trainsetLoop) {
            try {
                for (Trainset trainset : Trainset.trainsets) {
                    if (Integer.parseInt(inputTrainset) == trainset.ID) {
                        foundTrainset = true;
                        if (Trainset.isOnRoute()) {
                            trainsetOnRoute = true;
                            System.out.println("Trainset is already on the road, please select a different trainset.");
                            System.out.print("> ");
                            inputTrainset = scan.next();
                            break;
                        }
                        String source = trainset.getLocomotive().getSource().getName();
                        String destination = trainset.getLocomotive().getDestination().getName();
                        routeObj.setDistance(distance(source, destination));
                        routeObj.setFromTo("From " + source + " to " + destination);
                        System.out.println("Calculated distance is: " + routeObj.getDistance() + "km");
                        System.out.println(routeObj.getFromTo());
                        System.out.println("Do you want to travel right now?\n" +
                                "if \"yes\" input \"y\" if \"no\" input \"N\"");
                        System.out.print("y/N > ");
                        String input = scan.next();
                        boolean willTravel = input.equalsIgnoreCase("Y");
                        if (willTravel) routeObj.travelInBackground(routeObj.getDistance(), trainset);
                        else return;
                    } if (foundTrainset && !trainsetOnRoute) {
                        trainsetLoop = false;
                    } else if (!trainsetOnRoute) {
                        System.out.println("Please, enter the ID correctly");
                        System.out.print("> ");
                        inputTrainset = scan.next();
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer ID.");
                System.out.print("> ");
                inputTrainset = scan.next();
            }
        }

        System.out.println("Route added successfully to the route list\n");
        routes.add(routeObj);
    }

    public void travel(int distance, Trainset trainset) throws InterruptedException, RailroadHazard {
        System.out.println("Starting travel from " + fromTo);
        Thread.sleep(2000);

        System.out.print("\n> ");

        synchronized (Trainset.class) {
            while (Trainset.isOnRoute()) {
                System.out.println("Train is waiting for the route to be released...");
                Trainset.class.wait();
            }
            Trainset.setOnRoute(true);
        }

        for (int i = 0; i < distance; i += trainset.getLocomotive().getSpeed()) {
            System.out.println("Travelling to station " + (i + 1) + " out of " + distance);
            Thread.sleep(1000);
        }

        if (trainset.getLocomotive().getSpeed() > 200) {
            throw new RailroadHazard("TrainSet speed exceeds 200 km/h. Train set: " + trainset);
        }

        synchronized (Trainset.class) {
            Trainset.setOnRoute(false);
            Trainset.class.notifyAll();
        }

        System.out.print("\n> ");

        System.out.println("----------- " + trainset.getName() + " is arrived at the destination station -----------");
        System.out.println("Now waiting 30 seconds...");
        Thread.sleep(30000);

        synchronized (Trainset.class) {
            while (Trainset.isOnRoute()) {
                System.out.println("Train is waiting for the route to be released...");
                Trainset.class.wait();
            }
            Trainset.setOnRoute(true);
        }

        System.out.println("----------- " + trainset.getName() + " is returning back -----------");
        for (int i = distance; i >= 0 ; i -= trainset.getLocomotive().getSpeed()) {
            System.out.println("Travelling to station " + (i + 1) + " out of " + distance);
            Thread.sleep(1000);
        }

        System.out.println("----------- " + trainset.getName() + " returned -----------\n");
        Presentation.menu();
        System.out.print("> ");

        synchronized (Trainset.class) {
            Trainset.setOnRoute(false);
            Trainset.class.notifyAll();
        }
    }

    public void travelInBackground(final int distance, Trainset trainset) {
        Thread thread = new Thread(() -> {
            try {
                travel(distance, trainset);
            } catch (InterruptedException | RailroadHazard e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }
}
