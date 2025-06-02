 import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Flight> flights = new ArrayList<>();
        List<Reservation> reservations = new ArrayList<>();

        // Predefined flights
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            flights.add(new Flight("FL1001", "New York", "London", sdf.parse("2025-08-10 09:30")));
            flights.add(new Flight("FL2002", "Paris", "Tokyo", sdf.parse("2025-08-12 14:00")));
            flights.add(new Flight("FL3003", "Sydney", "Dubai", sdf.parse("2025-08-15 22:00")));
        } catch (ParseException e) {
            System.out.println("Error loading flights.");
        }

        while (true) {
            System.out.println("\n--- Airline Reservation System ---");
            System.out.println("1. View Available Flights");
            System.out.println("2. Book a Flight");
            System.out.println("3. View Reservations");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1 -> {
                    System.out.println("\nAvailable Flights:");
                    for (int i = 0; i < flights.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        flights.get(i).displayInfo();
                    }
                }

                case 2 -> {
                    System.out.print("Enter passenger name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter passport number: ");
                    String passport = scanner.nextLine();

                    System.out.println("Select a flight:");
                    for (int i = 0; i < flights.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        flights.get(i).displayInfo();
                    }

                    int flightChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (flightChoice < 1 || flightChoice > flights.size()) {
                        System.out.println("Invalid flight selection.");
                        break;
                    }

                    Flight selectedFlight = flights.get(flightChoice - 1);
                    Passenger passenger = new Passenger(name, passport);
                    String ticketNum = "TICKET" + (reservations.size() + 1);
                    double price = 599.99 + (Math.random() * 200); // Random price
                    Ticket ticket = new Ticket(ticketNum, Math.round(price * 100.0) / 100.0);

                    Reservation reservation = new Reservation(passenger, selectedFlight, ticket);
                    reservations.add(reservation);
                    System.out.println("Flight booked successfully!");
                    reservation.displayReservation();
                }

                case 3 -> {
                    if (reservations.isEmpty()) {
                        System.out.println("No reservations yet.");
                    } else {
                        for (Reservation r : reservations) {
                            r.displayReservation();
                        }
                    }
                }

                case 0 -> {
                    System.out.println("Thank you for using the Airline Reservation System!");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Invalid option.");
            }
        }
    }
}