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

    private void travel() {
        System.out.println("Choose the Trainset: [Enter the ID number]");
        Trainset.printTrainsets();

        System.out.print("> ");
        String inputTrainset = scan.next();

        for (Trainset trainset : Trainset.trainsets) {

        }
    }
}
