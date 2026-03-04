package compulsory;

public class Road {
    private String name;
    private String type;
    private Location firstLocation;
    private Location secondLocation;
    private int speedLimit;
    private double length;

    public Road() {
    }

    public Road(String name, String type, Location secondLocation, Location firstLocation, int speedLimit, double length) {
        this.name = name;
        this.speedLimit = speedLimit;
        this.secondLocation = secondLocation;
        this.firstLocation = firstLocation;
        this.type = type;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Location getFirstLocation() {
        return firstLocation;
    }

    public void setFirstLocation(Location firstLocation) {
        this.firstLocation = firstLocation;
    }

    public Location getSecondLocation() {
        return secondLocation;
    }

    public void setSecondLocation(Location secondLocation) {
        this.secondLocation = secondLocation;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return  " ----- ROAD -----\n" +
                "Name: " + name +
                "\nType: " + type +
                "\nFirst location: " + firstLocation.getName() +
                "\nSecond location: " + secondLocation.getName() +
                "\nSpeed limit: " + speedLimit +
                "\nLength: " + length;
    }
}
