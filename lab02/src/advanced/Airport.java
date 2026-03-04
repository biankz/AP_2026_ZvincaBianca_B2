package advanced;

/**
 * Clasa Airport reprezinta o locatie de tip aeroport.
 * Extinde clasa Location si adauga informatii specifice
 * precum codul aeroportului si numarul de terminale.
 */
public final class Airport extends Location {
    private int terminals;
    private String code;

    public Airport(String name, float latitude, float longitude, String code, int terminals) {
        super(name, latitude, longitude);
        this.code = code;
        this.terminals = terminals;
    }

    public int getTerminals() {
        return terminals;
    }

    public void setTerminals(int terminals) {
        this.terminals = terminals;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "--- AIRPORT ---\n" +
                "Name: " + getName() +
                "\nLatitude: " + getLatitude() +
                "\nLongitude: " + getLongitude() +
                "\nCode: " + code +
                "\nNumber of terminals: " + terminals;
    }
}
