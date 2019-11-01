package lab3;

public class FlightParser extends BaseParser{
    private static final int ID_AIRPORT_TO = 14;
    private static final int TIME_DELAY = 18;
    private static final int ID_AIRPORT_FROM = 11;
    private static final int FLAG_CANCELED = 19;
    private static final  String ZERO_DOUBLE = "0.0";

    public FlightParser(String str) {
        super(str);
    }
    public String getDelayIdAirport() {
        return getString(DELAY_COL);
    }
    public String getDelay() {
        String delay = getString(DELAY_NEW_COL);
        return delay.isEmpty() ? ZERO_DOUBLE : delay;
    }
}
