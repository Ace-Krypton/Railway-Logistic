public class Locomotive {
    private double speed = 100;
    private String name;
    private RailwayStation home;
    private int maxRailroadCars;
    private double maxWeight;
    private int maxElectricalGrid;

    public void setMaxRailroadCars(int maxRailroadCars) {
        this.maxRailroadCars = maxRailroadCars;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public void setMaxElectricalGrid(int maxElectricalGrid) {
        this.maxElectricalGrid = maxElectricalGrid;
    }

    private RailwayStation source;
    private RailwayStation destination;
    private static int id;
    public int ID;

    public Locomotive() {
        ++id;
        ID = id;
    }

    public double getSpeed() {
        return this.speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RailwayStation getHome() {
        return home;
    }

    public void setHome(RailwayStation home) {
        this.home = home;
    }

    public RailwayStation getSource() {
        return source;
    }

    public void setSource(RailwayStation source) {
        this.source = source;
    }

    public RailwayStation getDestination() {
        return destination;
    }

    public void setDestination(RailwayStation destination) {
        this.destination = destination;
    }

    public void updateSpeed() {
        double change = this.speed * 0.03 * (Math.random() > 0.5 ? 1 : -1);
        this.speed += change;
    }

    public String toString() {
        return ID + ". "
                + "Name: " + getName()
                + "\nHome: " + getHome().getName()
                + "\nSource: " + getSource().getName()
                + "\nDestination: " + getDestination().getName();
    }
}
