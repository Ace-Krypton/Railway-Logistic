import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Route {
    private static final Scanner scan = new Scanner(System.in);
    private static final Map<Character, Integer> distances = new HashMap<>();

    static {
        int distance = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            distances.put(c, distance);
            distance += 20;
        }
    }

    private void travel(Route routeObj) {
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
