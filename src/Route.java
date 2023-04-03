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

    public void generate(Route routeObj) throws InterruptedException {
        System.out.println("Choose the Trainset: [Enter the ID number]");
        Trainset.printTrainsets();

        System.out.print("> ");
        String inputTrainset = scan.next();
        boolean trainsetLoop = true;
        boolean foundTrainset = false;

        while (trainsetLoop) {
            try {
                for (Trainset trainset : Trainset.trainsets) {
                    if (Integer.parseInt(inputTrainset) == trainset.ID) {
                        foundTrainset = true;
                        String source = trainset.getLocomotive().getSource().getName();
                        String destination = trainset.getLocomotive().getDestination().getName();
                        routeObj.setDistance(distance(source, destination));
                        routeObj.setFromTo("From " + source + " to " + destination);
                        System.out.println("Calculated distance is: " + routeObj.getDistance() + "km");
                        System.out.println(routeObj.getFromTo());
                        routeObj.travelInBackground(routeObj.getDistance());
                    } if (foundTrainset) {
                        trainsetLoop = false;
                    } else {
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

        System.out.println("Route added successfully to the route list");
        routes.add(routeObj);
    }

    public void travel(int distance) throws InterruptedException {
        System.out.println("Starting travel from " + fromTo);
        Thread.sleep(2000);

        synchronized (Trainset.class) {
            while (Trainset.isOnRoute()) {
                System.out.println("Train is waiting for the route to be released...");
                Trainset.class.wait();
            }
            Trainset.setOnRoute(true);
        }

        for (int i = 0; i < distance; i += 2) {
            System.out.println("Travelling to station " + (i + 1) + " out of " + distance);
            Thread.sleep(1000);
        }

        synchronized (Trainset.class) {
            Trainset.setOnRoute(false);
            Trainset.class.notifyAll();
        }

        System.out.println("Arrived at the destination station");
        System.out.println("Now waiting 30 seconds...");
        Thread.sleep(30000);

        Route returnRoute = new Route();
        returnRoute.generate(new Route());
        returnRoute.travel(returnRoute.getDistance());
    }

    public void travelInBackground(final int distance) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                travel(distance);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        thread.join();
    }
}
