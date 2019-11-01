package lab3;

import java.io.Serializable;

public class FlightSerializable implements Serializable {
    private static final long ZERO = 0;
    private static final long ONE = 1;
    //private static final long TOTAL = 100;
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
                Math.max(maximumLatency, lateness),
                numberOfFlights+1,
                numberOfDelayedFlights + (lateness != 0 ? ONE : ZERO),
                canceledFlight + (canceled ? ONE : ZERO)
        );
    }
    public float calculatePercentAFromB(long a, long b){
        return ((float)a/b)*100;
    }
    public float getPercentDelayedFlight() {
        return ((float)numberOfDelayedFlights/numberOfFlights)*100;
        //return calculatePercentAFromB(numberOfDelayedFlights, numberOfFlights);
    }
    public float getPercentCanceledFlight(){
        return ((float)canceledFlight/numberOfFlights)*100;
        //return calculatePercentAFromB(canceledFlight, numberOfFlights);
    }
    public long getMaximumLatency() {
        return maximumLatency;
    }

    public long getNumberOfFlights() {
        return numberOfFlights;
    }

    public long getNumberOfDelayedFlights() {
        return numberOfDelayedFlights;
    }
    public long getCanceledFlight() {
        return canceledFlight;
    }

    @Override
    public String toString() {
        return "MaximumLatency = " + getMaximumLatency() +
                " PercentDelayedFlight =  " +
                String.format("%.2f%%", getPercentDelayedFlight()) +
                " PercentCanceledFlight =  " +
                String.format("%.2f%%", getPercentCanceledFlight()) +
                " DelayedFlight = " +
                getNumberOfDelayedFlights() +
                " Flight = " +
                getNumberOfFlights() +
                " Canceled = " +
                getCanceledFlight();
    }
}
