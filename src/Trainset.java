import java.util.ArrayList;
import java.util.Scanner;

public class Trainset {
    private static final Scanner scan = new Scanner(System.in);
    public static final ArrayList<Object> trainsets = new ArrayList<>();
    private String name;
    private static int id;
    public int ID;

    public Trainset() {
        ++id;
        ID = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void createTrainsets(Trainset trainsetObj) {
        System.out.print("Enter the name of the trainset: ");
        String name = scan.next();
        trainsetObj.setName(name);

        System.out.println("Choose the locomotive: [Enter the ID number]");
        Locomotive.printLocomotives();

        System.out.print("> ");
        String input = scan.next();
        boolean locomotiveLoop = true;
        boolean foundLocomotive = false;

        while (locomotiveLoop) {
            for (Locomotive locomotive : Locomotive.locomotives) {
                if (Integer.parseInt(input) == locomotive.ID) {
                    foundLocomotive = true;
                    trainsets.add(locomotive);
                    Locomotive.locomotives.remove(locomotive);
                    System.out.println(locomotive.getName() + " added successfully to the Locomotive\n");
                    break;
                }
            } if (foundLocomotive) {
                locomotiveLoop = false;
            } else {
                System.out.println("Please, enter the ID correctly");
                System.out.print("> ");
                input = scan.next();
            }
        }
    }

    public static void print() {
        for (Object trainset : trainsets) {
            System.out.println(trainset);
        }
    }
}
