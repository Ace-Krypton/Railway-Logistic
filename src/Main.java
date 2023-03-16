import java.util.Locale;
import java.util.Scanner;

public class Main {
    /*
    NOTES
    First Day of the project:
    started at 8:30
    ended at
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        boolean loop = true;
        MAINLOOP:
        while (loop) {
            menu();
            System.out.print("> ");
            input = scan.next();
            switch(input.toLowerCase(Locale.ROOT)) {
                case "1" -> {

                }
            }
        }
    }

    private static void menu() {
        System.out.println("[1] Create Locomotive");
        System.out.println("[0] Exit");
    }
}
