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
    public String getIdAirportDest() {
        String id = getString(ID_AIRPORT_DEST);
        return id.isEmpty() ? ZERO_DOUBLE : id;
        //return getString(ID_AIRPORT_DEST);
        //return getLong(ID_AIRPORT_DEST);
    }
    public String getDelay() {
        String delay = getString(TIME_DELAY);
        return delay.isEmpty() ? ZERO_DOUBLE : delay;
        //return getLong(TIME_DELAY);
    }
    public String getIdAirportFrom(){
        String id = getString(ID_AIRPORT_FROM);
        return id.isEmpty() ? ZERO_DOUBLE : id;
        //return getString(ID_AIRPORT_FROM);
        //return getLong(ID_AIRPORT_FROM);
    }
    public Boolean getFlagCanceled() {
        return (long)Double.parseDouble(getString(FLAG_CANCELED)) == 1;
    }
}
