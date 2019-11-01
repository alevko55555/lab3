package lab3;

public class AirportParser extends BaseParser{
    public AirportParser(String str) {
        super(str);
    }
    public String getIdAirport() {
        return getString(0);
    }
    public String getInfoAirport() {
        return getString(1);
    }
}
