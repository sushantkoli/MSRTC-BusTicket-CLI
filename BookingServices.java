import java.util.List;
import java.util.ArrayList;

import java.util.Iterator;

public class BookingServices {
    private List<Bus> buses= new ArrayList<>();
    private List<Ticket> tickets= new ArrayList<>();

    public BookingServices(){
        buses.add(new Bus("MH-18-CD-9035", "Dhule", "Sakri", 50));
        buses.add(new Bus("MH-18-AB-4721", "Dhule", "Shirpur", 40));
        buses.add(new Bus("MH-18-EF-6612", "Dhule", "Nandurbar", 58));
        buses.add(new Bus("MH-18-GH-1184", "Dhule", "Nashik", 47));
        buses.add(new Bus("MH-18-JK-5529", "Shirpur", "Sakri", 60));
        buses.add(new Bus("MH-18-LM-8823", "Shirpur", "Dhule", 80));
        buses.add(new Bus("MH-01-NO-4521", "Mumbai", "Thane", 60));
    }

    public List<Bus> searchBus(String source ,String destination){
        List<Bus> temp=new ArrayList<>();
        for(Bus b: buses) {
            if (b.getSource().equalsIgnoreCase(source) && b.getDestination().equalsIgnoreCase(destination)) {
                System.out.println("Bus Found");
                System.out.println(b);
                temp.add(b);
                return temp;
            }
        }
        System.out.println("Sorry Bus Not Available. \n Showing Available Buses ");
        ListOfBuses();
        return temp;
    }
    public Ticket bookTicket(User user, String busNumber, int seatCount){
        for(Bus b: buses){
            if(b.getBusNumber().equalsIgnoreCase(busNumber)) {

               if( b.bookTickets(seatCount)) {
                   Ticket ticket=new Ticket(user,b,seatCount);
                   tickets.add(ticket);
                   return ticket;
               }
               else{
                   System.out.println("Not Enough Seats Availble");
                   return null;
               }

            }
        }
        System.out.println("Incorrect bus Number");
        return null;
    }
    public List<Ticket> ticketByUser(User user){
        List<Ticket> res=new ArrayList<>();
        for(Ticket t: tickets) {
            if (t.getUser().getUsername().equalsIgnoreCase(user.getUsername())) res.add(t);
        }
        return res;
   }
    public boolean cancelTicket(int ticketId,User user){
        Iterator<Ticket> it = tickets.iterator();

        while (it.hasNext()) {
            Ticket t = it.next();
            if(t.getTicketId()==ticketId && t.getUser().getUsername().equals(user.getUsername())){
                Bus b=t.getBus();
                b.cancelTickets(t.getSeatBook());
                it.remove();
                System.out.println("Ticket "+ticketId+" cancle Succesfully.");
                return true;
            }
        }
        System.out.println("Ticket Not found for thid User");
        return false;

    }
    public void ListOfBuses(){
        for(Bus b:buses) System.out.println(b);
    }
}
