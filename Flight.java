 import java.util.Date;

public class Flight {
    private final String flightNumber;
    private final String departure;
    private final String arrival;
    private final Date departureTime;

    public Flight(String flightNumber, String departure, String arrival, Date departureTime) {
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.arrival = arrival;
        this.departureTime = departureTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void displayInfo() {
        System.out.println(flightNumber + " | " + departure + " -> " + arrival + " at " + departureTime);
    }
}
