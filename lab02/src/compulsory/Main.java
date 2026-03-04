package compulsory;

public class Main {
    static void main(String[] args) {
        Location city1 = new Location("Iasi", "city", (float)47.1598, (float)27.5872);

        Location city2 = new Location();
        city2.setName("Botosani");
        city2.setType("city");
        city2.setLatitude((float)47.7486);
        city2.setLongitude((float)26.6694);

        Location university = new Location("UAIC", "university", (float)47.1721, (float)27.5744);
        Location busStation = new Location();
        busStation.setName("Aurogara Iasi Vest");
        busStation.setType("bus station");
        busStation.setLatitude((float)47.1736);
        busStation.setLongitude((float)27.5541);

        Road european = new Road("E58", "european", city1, city2, 90, 108);

        Road cityRoad = new Road();
        cityRoad.setName("Bulevardul Carol I");
        cityRoad.setType("city road");
        cityRoad.setFirstLocation(university);
        cityRoad.setSecondLocation(busStation);
        cityRoad.setSpeedLimit(50);
        cityRoad.setLength(3);

        System.out.println(city1);
        System.out.println(city2);
        System.out.println(university);
        System.out.println(busStation);
        System.out.println(european);
        System.out.println(cityRoad);
    }
}
