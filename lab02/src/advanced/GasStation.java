package advanced;
/**
 * Clasa GasStation reprezinta o locatie de tip benzinarie.
 * Extinde clasa Location si adauga informatii despre
 * pretul combustibilului si brandul statiei.
 */
public final class GasStation extends Location {
    private int gasPrice;
    private String brand;

    public GasStation(String name, float latitude, float longitude, int gasPrice, String brand) {
        super(name, latitude, longitude);
        this.gasPrice = gasPrice;
        this.brand = brand;
    }

    public int getGasPrice() {
        return gasPrice;
    }

    public void setGasPrice(int gasPrice) {
        this.gasPrice = gasPrice;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "--- AIRPORT ---\n" +
                "Name: " + getName() +
                "\nLatitude: " + getLatitude() +
                "\nLongitude: " + getLongitude() +
                "\nBrand: " + brand +
                "\nGas price: " + gasPrice;
    }
}