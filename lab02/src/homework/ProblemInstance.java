package homework;

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
                if (roads[i].getFirstLocation().equals(locations[j])){
                    firstLocationFound = true;
                }
                if (roads[i].getSecondLocation().equals(locations[j])){
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

    private boolean dfs(Location current, Location end, boolean[] visited) {
        int currentIndex = findLocationIndex(current);
        if (currentIndex == -1) {
            return false;
        }
        if (current.equals(end)) {
            return true;
        }
        if (visited[currentIndex]) {
            return false;
        }
        visited[currentIndex] = true;

        for (int i = 0; i < roadCount; i++) {
            if (roads[i].getFirstLocation().equals(current)) {
                Location next = roads[i].getSecondLocation();
                int nextIndex = findLocationIndex(next);
                if (nextIndex != -1 && !visited[nextIndex]) {
                    if (dfs(next, end, visited)) return true;
                }
            }

            if (roads[i].getSecondLocation().equals(current)) {
                Location next = roads[i].getFirstLocation();
                int nextIndex = findLocationIndex(next);
                if (nextIndex != -1 && !visited[nextIndex]) {
                    if (dfs(next, end, visited)) return true;
                }
            }
        }
        return false;
    }

    public boolean checkPath(Location firstLoc, Location secondLoc){
        boolean[] visited = new boolean[locationCount];
        return dfs(firstLoc, secondLoc, visited);
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
