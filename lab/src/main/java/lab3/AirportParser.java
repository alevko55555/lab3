package lab3;

public class AirportParser extends BaseParser{
    private static final int ID_ROW = 0;
    private static final int NAME_ROW = 1;

    public AirportParser(String str) {
        super(str);
    }
    public String getIdAirport() {
        //return getLong(ID_ROW);
        return getString(ID_ROW);
    }
    public String getInfoAirport() {
        return getString(NAME_ROW);
    }
}
