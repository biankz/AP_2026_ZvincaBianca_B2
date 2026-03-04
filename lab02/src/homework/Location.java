package homework;

import java.util.Objects;

/**
 * Clasa abstracta Location reprezinta o locatie geografica.
 * Aceasta contine informatii de baza precum numele locatiei,
 * latitudinea si longitudinea.
 *
 * Clasa este sealed, ceea ce inseamna ca poate fi extinsa
 * doar de clasele City, Airport si GasStation.
 */
public abstract sealed class Location
        permits City, Airport, GasStation {
    private String name;
    private float latitude;
    private float longitude;

    protected Location(String name, float latitude, float longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public final double distanceTo(Location other) {
        double dx = this.latitude - other.latitude;
        double dy = this.longitude - other.longitude;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Location location)) return false;
        return Float.compare(latitude, location.latitude) == 0 && Float.compare(longitude, location.longitude) == 0 && Objects.equals(name, location.name);
    }

    @Override
    public String toString() {
        return "----- LOCATION -----\n" +
                "Name: " + name +
                "\nLatitude: " + latitude +
                "\nLongitude: " + longitude;
    }
}
