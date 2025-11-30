public class Ticket {
    private User user;
    private int ticketId;
    private Bus bus;
    private int seatBook;
    private static int  ticketCounter=101;

    public Ticket(User user, Bus bus, int seatBook) {
        this.user = user;
        this.ticketId = ticketCounter++;
        this.bus = bus;
        this.seatBook = seatBook;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public int getSeatBook() {
        return seatBook;
    }

    public void setSeatBook(int seatBook) {
        this.seatBook = seatBook;
    }

    public static int getTicketCounter() {
        return ticketCounter;
    }

    public static void setTicketCounter(int ticketCounter) {
        Ticket.ticketCounter = ticketCounter;
    }

    @Override
    public String toString() {
        return "\n----------------------------\n" +
                " Ticket Details\n" +
                "----------------------------\n" +
                " Ticket ID: " + ticketId + "\n" +
                " Bus Number: " + bus.getBusNumber() + "\n" +
                " Route: " + bus.getSource() + " -> " + bus.getDestination() + "\n" +
                " Seats Booked: " + getSeatBook() + "\n" +
                " Booked By: " + user.getUsername() + "\n" +
                "----------------------------\n";
    }
}
