package lab3;

import java.io.Serializable;

public class FlightSerializable implements Serializable {
    private long maximumLatency;
    private long numberOfFlights;
    private long numberOfDelayedFlights;
    private long canceledFlight;
    public FlightSerializable(long minValue, int i, int i1, int i2) {
    }
    public FlightSerializable(){
        this(Long.MIN_VALUE, 0, 0, 0);
    }
}
