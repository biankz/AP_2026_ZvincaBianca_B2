package compulsory;

public class Location {
    private String name;
    private String type;
    private float latitude;
    private float longitude;

    public Location() {
    }

    public Location(String name, String type, float latitude, float longitude) {
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.name = name;
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

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public double distanceTo(Location other) {
        double dx = this.latitude - other.latitude;
        double dy = this.longitude - other.longitude;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "----- LOCATION -----\n" +
                "Name: " + name +
                "\nType: " + type +
                "\nLatitude: " + latitude +
                "\nLongitude: " + longitude;
    }
}
