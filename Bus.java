public class Bus {
  private String busNumber;
  private  String source;
  private String destination;
  private int totalSeats;
  private int availableSeats;

    public Bus(String busNumber, String source, String destination, int totalSeats) {
        this.busNumber = busNumber;
        this.source = source;
        this.destination = destination;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }


    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public boolean bookTickets(int count){
        if(count<=availableSeats){
            availableSeats-=count;
            return true;
        }
        return false;
    }
    public boolean cancelTickets(int count) {
        if (availableSeats + count > totalSeats) {
            return false; // cannot cancel more than total seats
        }

        availableSeats += count;
        return true;
    }


    @Override
    public String toString() {
        return "Bus { " +
                "BusNumber: '" + busNumber + '\'' +
                ", From: " + source +
                " --> To: " + destination +
                ", Total Seats: " + totalSeats +
                ", Available Seats: " + availableSeats +
                " }";
    }

}