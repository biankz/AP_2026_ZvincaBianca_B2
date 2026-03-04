package advanced;
/**
 * Clasa City reprezinta o locatie de tip oras.
 * Extinde clasa Location si adauga informatii
 * despre populatie si suprafata totala.
 */
public final class City extends Location {
    private int population;
    private int totalArea;

    public City(String name, float latitude, float longitude, int population, int totalArea) {
        super(name, latitude, longitude);
        this.population = population;
        this.totalArea = totalArea;
    }

    public int getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(int totalArea) {
        this.totalArea = totalArea;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "--- CITY ---\n" +
                "Name: " + getName() +
                "\nLatitude: " + getLatitude() +
                "\nLongitude: " + getLongitude() +
                "\nPopulation: " + population +
                "\nTotal area: " + totalArea;
    }
}
