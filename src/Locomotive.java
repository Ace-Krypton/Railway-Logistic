public class Locomotive {
    private String name;
    private RailwayStation home;
    private RailwayStation source;
    private RailwayStation destination;
    private static int id;
    int ID;

    public Locomotive() {
        ++id;
        ID = id;
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

    public String toString() {
        return ID + " ";
    }
}
