package advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Clasa ProblemInstance reprezinta instanta problemei.
 * Contine locatiile si drumurile dintre ele si ofera
 * metode pentru verificarea validitatii si a existentei
 * unui drum intre doua locatii.
 */
public class ProblemInstance {
    private Location[] locations;
    private Road[] roads;
    private int locationCount;
    private int roadCount;

    public ProblemInstance() {
        this.locations = new Location[10];
        this.roads = new Road[10];
        this.locationCount = 0;
        this.roadCount = 0;
    }

    public Location[] getLocations() {
        return locations;
    }

    public void setLocations(Location[] locations) {
        this.locations = locations;
    }

    public Road[] getRoads() {
        return roads;
    }

    public void setRoads(Road[] roads) {
        this.roads = roads;
    }

    public boolean addLocation(Location location) {
        for (int i = 0; i < locationCount; i++) {
            if (locations[i].equals(location)) {
                return false;
            }
        }
        if (locationCount < locations.length) {
            locations[locationCount++] = location;
            return true;
        }
        return false;
    }

    public boolean addRoad(Road road) {
        for (int i = 0; i < roadCount; i++) {
            if (roads[i].equals(road)) {
                return false;
            }
        }
        if (roadCount < roads.length) {
            roads[roadCount++] = road;
            return true;
        }
        return false;
    }

    public boolean isValid(){
        for (int i = 0; i < roadCount; i++) {
            boolean firstLocationFound = false;
            boolean secondLocationFound = false;
            for (int j = 0; j < locationCount; j++) {
                if(roads[i].getFirstLocation().equals(locations[j])){
                    firstLocationFound = true;
                }
                if(roads[i].getSecondLocation().equals(locations[j])){
                    secondLocationFound = true;
                }
            }
            if (!firstLocationFound || !secondLocationFound){
                return false;
            }
        }
        return true;
    }

    private int findLocationIndex(Location location){
        for (int i = 0; i < locationCount; i++){
            if (locations[i].equals(location)){
                return i;
            }
        }
        return -1;
    }

    public List<Location> bestRoute(Location start, Location end) {
        int n = locationCount;
        int startIndex = findLocationIndex(start);
        int endIndex = findLocationIndex(end);

        if (startIndex == -1 || endIndex == -1) {
            return Collections.emptyList();
        }

        double[] dist = new double[n];
        boolean[] used = new boolean[n];
        int[] parent = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = Double.POSITIVE_INFINITY;
            parent[i] = -1;
        }
        dist[startIndex] = 0;

        for (int step = 0; step < n; step++) {
            int u = -1;
            double best = Double.POSITIVE_INFINITY;

            // alegem nodul nefolosit cu distanta minima
            for (int i = 0; i < n; i++) {
                if (!used[i] && dist[i] < best) {
                    best = dist[i];
                    u = i;
                }
            }

            if (u == -1) { // nu mai exista noduri accesibile
                break;
            }
            if (u == endIndex) { // am ajuns la destinatie
                break;
            }

            used[u] = true;

            Location current = locations[u];

            for (int i = 0; i < roadCount; i++) {
                Road r = roads[i];
                Location a = r.getFirstLocation();
                Location b = r.getSecondLocation();

                Location neighbor = null;
                if (a.equals(current)) {
                    neighbor = b;
                }
                else if (b.equals(current)) {
                    neighbor = a;
                }
                else continue;

                int v = findLocationIndex(neighbor);
                if (v == -1 || used[v]) {
                    continue;
                }

                double w = r.getLength();
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    parent[v] = u;
                }
            }
        }
        if (dist[endIndex] == Double.POSITIVE_INFINITY) {
            return Collections.emptyList(); // nu există ruta
        }

        // reconstruim ruta din parent
        List<Location> path = new ArrayList<>();
        for (int v = endIndex; v != -1; v = parent[v]) {
            path.add(locations[v]);
        }
        Collections.reverse(path);
        return path;
    }

    public void printRoadsAndLocations(){
        System.out.println("Locations: ");
        for (int i = 0; i < locationCount; i++){
            System.out.println(locations[i]);
        }
        System.out.println("Roads: ");
        for (int i = 0; i < roadCount; i++){
            System.out.println(roads[i]);
        }
    }
}
