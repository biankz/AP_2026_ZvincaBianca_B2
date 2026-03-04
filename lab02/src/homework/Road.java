package homework;
import java.util.Objects;

/**
 * Clasa Road reprezinta un drum care leaga doua locatii.
 * Contine informatii despre nume, tip, lungime si limita de viteza.
 */
public class Road {
    private String name;
    private RoadType type;
    private Location firstLocation;
    private Location secondLocation;
    private int length;
    private int speedLimit;

    public Road(String name, int speedLimit, int length, Location secondLocation, Location firstLocation, RoadType type) {
        this.name = name;
        this.speedLimit = speedLimit;
        double minDistance = firstLocation.distanceTo(secondLocation);
        if (length < minDistance) {
            throw new IllegalArgumentException(
                    "Road length (" + length + ") is smaller than euclidean distance (" + minDistance + ")."
            );
        }
        this.secondLocation = secondLocation;
        this.firstLocation = firstLocation;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public Location getSecondLocation() {
        return secondLocation;
    }

    public void setSecondLocation(Location secondLocation) {
        this.secondLocation = secondLocation;
    }

    public Location getFirstLocation() {
        return firstLocation;
    }

    public void setFirstLocation(Location firstLocation) {
        this.firstLocation = firstLocation;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Road road)) return false;
        return Objects.equals(name, road.name) && type == road.type && Objects.equals(firstLocation, road.firstLocation) && Objects.equals(secondLocation, road.secondLocation);
    }



    @Override
    public String toString() {
        return "----- ROAD -----\n" +
                "Name: " + name +
                "\nType: " + type +
                "\nFirst location: " + firstLocation.getName() +
                "\nSecond location: " + secondLocation.getName() +
                "\nLength: " + length +
                "\nSpeed Limit: " + speedLimit;
    }
}
