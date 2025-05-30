public class Reservation {
    private final Passenger passenger;
    private final Flight flight;
    private final Ticket ticket;

    public Reservation(Passenger passenger, Flight flight, Ticket ticket) {
        this.passenger = passenger;
        this.flight = flight;
        this.ticket = ticket;
    }

    public void displayReservation() {
        System.out.println("\n--- Reservation Details ---");
        System.out.println("Passenger: " + passenger.getName());
        System.out.println("Passport No.: " + passenger.getPassportNumber());
        System.out.println("Flight: " + flight.getFlightNumber() + " (" + flight.getDeparture() + " -> " + flight.getArrival() + ")");
        System.out.println("Ticket No.: " + ticket.getTicketNumber());
        System.out.println("Price: $" + ticket.getPrice());
        System.out.println("----------------------------");
    }
}
