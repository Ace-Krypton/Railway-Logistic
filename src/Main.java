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
    ended at ?
    */
    static RailwayStation station = new RailwayStation();

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
                case "2" -> station.createLocomotives(new Locomotive());
                case "0" -> loop = false;
                default -> System.out.println("Please, choose correct number\n");
            }
        }
    }

    private static void menu() {
        System.out.println("[1] Create Railway Station");
        System.out.println("[2] Create Locomotive");
        System.out.println("[0] Exit");
    }
}
