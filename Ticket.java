public class Ticket {
    private final String ticketNumber;
    private final double price;

    public Ticket(String ticketNumber, double price) {
        this.ticketNumber = ticketNumber;
        this.price = price;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public double getPrice() {
        return price;
    }
}
