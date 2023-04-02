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

    private void generate(Route routeObj) {
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
                        char source = trainset.getLocomotive().getSource().getName().charAt(0);
                        char destination = trainset.getLocomotive().getDestination().getName().charAt(0);
                        routeObj.setDistance(distances.get(destination) - distances.get(source));
                        routeObj.setFromTo("From " + trainset.getLocomotive().getSource().getName() +
                                " to" + trainset.getLocomotive().getDestination().getName());
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
