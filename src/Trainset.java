import java.util.ArrayList;
import java.util.Scanner;

public class Trainset {
    private static final Scanner scan = new Scanner(System.in);
    public static final ArrayList<Locomotive> trainsetLocomotives = new ArrayList<>();
    public static final ArrayList<RailroadCar> trainsetRailroadCars = new ArrayList<>();
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
        String inputLocomotive = scan.next();
        boolean locomotiveLoop = true;
        boolean foundLocomotive = false;

        while (locomotiveLoop) {
            for (Locomotive locomotive : Locomotive.locomotives) {
                if (Integer.parseInt(inputLocomotive) == locomotive.ID) {
                    foundLocomotive = true;
                    trainsetLocomotives.add(locomotive);
                    Locomotive.locomotives.remove(locomotive);
                    System.out.println(locomotive.getName() + " added successfully to the Trainset\n");

                    boolean railroadCarLoop = true;
                    int railroadCount = 0;
                    int electricalGridCount = 0;
                    double weight = 0;

                    while (railroadCarLoop) {
                        System.out.println("Choose the railroad car: [Enter the ID number]");
                        RailroadCar.printRailroadCars();
                        System.out.print("> ");
                        String inputRailroad = scan.next();
                        boolean foundRailroadCar = false;
                        for (RailroadCar railroadCar : RailroadCar.railroadCars) {
                            if (Integer.parseInt(inputRailroad) == railroadCar.ID) {
                                foundRailroadCar = true;
                                if (locomotive.getMaxWeight() >= railroadCar.getGrossWeight() &&
                                        locomotive.getMaxWeight()  >= weight + 1 &&
                                        locomotive.getMaxRailroadCars() >= railroadCount + 1 &&
                                        locomotive.getMaxElectricalGrid() >= electricalGridCount + 1) {
                                    if (railroadCar.isRequiresElecticalGrid()) electricalGridCount++;
                                    weight += railroadCar.getGrossWeight();
                                    trainsetRailroadCars.add(railroadCar);
                                    RailroadCar.railroadCars.remove(railroadCar);
                                    railroadCount++;
                                    System.out.println("Railroad car added successfully");
                                } else {
                                    System.out.println("This locomotive cannot pull this railroad car.");
                                }
                                break;
                            }
                        }
                        if (!foundRailroadCar) {
                            System.out.println("Please, enter the ID correctly");
                        }
                        System.out.println("Do you want to add more railroad cars?\n" +
                                "if \"yes\" input \"y\" if \"no\" input \"N\"");
                        System.out.print("y/N > ");
                        String input = scan.next();
                        railroadCarLoop = input.equalsIgnoreCase("Y");
                    }
                    break;
                }
            }
            if (foundLocomotive) {
                locomotiveLoop = false;
            } else {
                System.out.println("Please, enter the ID correctly");
                System.out.print("> ");
                inputLocomotive = scan.next();
            }
        }
    }

    public static void print() {
        for (Locomotive trainset : trainsetLocomotives) {
            System.out.println(trainset);
        }
    }

    public static void printRailroadCars() {
        for (RailroadCar railroadCar : trainsetRailroadCars) {
            System.out.println(railroadCar);
        }
    }
}
