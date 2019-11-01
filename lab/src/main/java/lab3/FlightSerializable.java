package lab3;

import java.io.Serializable;

public class FlightSerializable implements Serializable {
    private static final long ZERO = 0;
    private long maximumLatency;
    private long numberOfFlights;
    private long numberOfDelayedFlights;
    private long canceledFlight;
    public FlightSerializable(long maximumLatency, long numberOfFlights, long numberOfDelayedFlights, long canceledFlight) {
        this.maximumLatency = maximumLatency;
        this.numberOfFlights = numberOfFlights;
        this.numberOfDelayedFlights = numberOfDelayedFlights;
        this.canceledFlight = canceledFlight;
    }
    public FlightSerializable(){
        this(Long.MIN_VALUE, ZERO, ZERO, ZERO);
    }
    public FlightSerializable append(FlightSerializable next) {
        return new FlightSerializable(
                Math.max(maximumLatency, next.maximumLatency),
                numberOfFlights + next.numberOfFlights,
                numberOfDelayedFlights + next.numberOfDelayedFlights,
                canceledFlight + next.canceledFlight
        );
    }
    public FlightSerializable append(long lateness, boolean canceled) {
        return new FlightSerializable(
                
        )
    }
    public long getMaximumLatency() {
        return maximumLatency;
    }
    public long getNumberOfFlights() {
        return  numberOfFlights;
    }
    public long getNumberOfDelayedFlights() {
        return numberOfDelayedFlights;
    }
    public long getCanceledFlight() {
        return canceledFlight;
    }
}
