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
        return getString(ID_AIRPORT_DEST);
    }
    public String getDelay() {
        String delay = getString(TIME_DELAY);
        return delay.isEmpty() ? ZERO_DOUBLE : delay;
    }
    public String getIdAirportFrom(){
        return getString(ID_AIRPORT_FROM);
    }
    public Boolean getFlagCanceled() {
        return getString(FLAG_CANCELED) == 1;
    }
}
