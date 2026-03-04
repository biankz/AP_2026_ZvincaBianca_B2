package homework;

/**
 * Clasa principala a programului.
 * Creeaza o instanta a problemei, adauga locatii si drumuri
 * si testeaza functionalitatea aplicatiei.
 */
public class Main {
    public static void main(String[] args) {
        ProblemInstance p = new ProblemInstance();

        City c1 = new City("Botosani", (float)47.7486, (float)27.5541, 90010, 41);
        City c2 = new City("Iasi", (float)47.1598, (float)27.5872, 271962, 94);

        Airport a1 = new Airport("Iasi International Airport", (float)47.1563, (float)27.5841, "IAS", 4);
        GasStation s1 = new GasStation("Lukoil Sfantul Lazar", (float)47.1563, (float)27.5850, 8, "Lukoil");

        p.addLocation(c1);
        p.addLocation(c2);
        p.addLocation(a1);
        p.addLocation(s1);

        p.addRoad(new Road("E58", 90, 108, c1, c2, RoadType.EUROPEAN_ROAD));
        p.addRoad(new Road("Soseaua Ciric", 50, 5, s1, a1, RoadType.CITY_ROAD));

        System.out.println("Valid? " + p.isValid());
        System.out.println("Reach c2 from c1? " + p.checkPath(c1, c2));
    }
}