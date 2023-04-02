import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Route {
    private String fromTo;
    private int distance;
    private static final Scanner scan = new Scanner(System.in);
    private static final Map<Character, Integer> distances = new HashMap<>();

    static {
        int distance = 0;
        for (char c = 'a'; c <= 'z'; c++) {
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
        int i = 0, j = 0;
        int dist = 0;
        while (i < s1.length() && j < s2.length()) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);
            if (c1 != c2) {
                dist += Math.abs(distances.get(c1) - distances.get(c2));
                break;
            }
            i++;
            j++;
        }
        return dist;
    }

    public void generate(Route routeObj) {
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
                        routeObj.setFromTo("From " + source + " to" + destination);
                        System.out.println("Distance is: " + routeObj.getDistance());
                        System.out.println("FromTO: " + routeObj.getFromTo());
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
    }
}
