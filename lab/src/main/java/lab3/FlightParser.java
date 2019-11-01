package lab3;

public class FlightParser extends BaseParser{
    private static final int ID_AIRPORT_DEST = 14;
    private static final int TIME_DELAY = 18;
    private static final int ID_AIRPORT_FROM = 11;
    private static final int FLAG_CANCELED = 19;
    private static final  String ZERO_DOUBLE = "0.0";

    public FlightParser(String str) {
        super(str);
    }
    public Long getIdAirportDest() {
        return getLong(ID_AIRPORT_DEST);
    }
    public Long getDelay() {
        return getLong(TIME_DELAY);
    }
    public Long getIdAirportFrom(){
        return getLong(ID_AIRPORT_FROM);
    }
    public Boolean getFlagCanceled() {
        return (long)Double.parseDouble(getString(FLAG_CANCELED)) == 1;
    }
}
