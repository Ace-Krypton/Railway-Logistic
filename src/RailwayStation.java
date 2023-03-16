import java.util.Scanner;

public class RailwayStation {
    private String name;
    private String location;

    public void createLocomatives(Locomotive locomotiveObjs) {
        Scanner scan = new Scanner(System.in);
        String input;

        System.out.print("Enter the name of the locomotive: ");
        input = scan.next();
        locomotiveObjs.setName(input);

        System.out.println("Choose the home railway station: ");

    }
}
