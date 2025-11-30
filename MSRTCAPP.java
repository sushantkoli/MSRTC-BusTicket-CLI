import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class MSRTCAPP {
   static Scanner sc=new Scanner(System.in);
   static UserServices userServices=new UserServices();
   static BookingServices bookingServices=new BookingServices();
    public static void main(String[] args) {

        while(true){

            if(userServices.isLogin()) {

                System.out.println("--------------UserMenu-----------------");
                System.out.println("\n 1.Search Buses \n 2.Book Ticket \n 3.View MyTicket \n 4.Cancle Ticket \n 5.View All-Buses \n 6.LogOut \n Enter Your Choice:");
                int ch = sc.nextInt();
                switch (ch) {
                    case 1 -> searchBus();
                    case 2 -> bookTicket();
                    case 3 -> myTickets();
                    case 4 -> cancelTickets();
                    case 5 -> bookingServices.ListOfBuses();
                    case 6 -> userServices.logoutUser();
                    default -> System.out.println("Invalid Choice");
                }
            }
            else{
                System.out.println("--------------WelCome-----------------");
                System.out.println("\n 1.Register \n 2.Login \n 3.Exit \n Enter Your Choice:");
                int ch=sc.nextInt();
                switch (ch){
                    case 1 -> register();
                    case 2 -> login();
                    case 3 -> exit();
                    default -> System.out.println("Invalid Choice");
                }
            }
        }

    }

    public static void register(){
        System.out.println("Enter Your Name:");
        String name=sc.next();
        System.out.println("Enter Mobile Number:");
        String mobileNum=sc.next();
        System.out.println("Enter username:");
        String username=sc.next();
        System.out.println("Enter Password:");
        String password=sc.next();
        userServices.registerUser(name,mobileNum,password,username);
    }
    public static void login(){
        System.out.println("Enter username:");
        String username=sc.next();
        System.out.println("Enter Password:");
        String password=sc.next();
        userServices.userLogin(username,password);
    }
        public static void exit(){
            System.out.println("--------------Thank you For using MSRTCAPP------------------");
            System.exit(0);
        }

   //For User Menu

       public static void searchBus() {
            System.out.println("Enter Source: Eg.(DHULE)");
            String source = sc.next();
            System.out.println("Enter Destination: Eg.(Shirpur)");
            String dest = sc.next();
            bookingServices.searchBus(source, dest);
            System.out.println("Do you want to Book Ticket: Enter (Y\\N):");
            if(sc.next().equalsIgnoreCase("Y")) bookTicket();

        }
        public static void bookTicket(){
            bookingServices.ListOfBuses();
            System.out.println("Enter Bus Number ( With \'-\':");
            String busno=sc.next();
            System.out.println("Enter Number of Seats:");
            int s=sc.nextInt();
            Ticket ticket= bookingServices.bookTicket(userServices.getCurrentUser(),busno,s);
            if(ticket!=null){
                System.out.println("-----------Booking succefull-------------");
                System.out.println(ticket);
            }
            else {
                System.out.println("----------------Returning to menu..----------------");
            }
        }
        public static void myTickets(){
            List<Ticket> ticketByMe=bookingServices.ticketByUser(userServices.getCurrentUser());
            if(ticketByMe.isEmpty()) System.out.println("No Ticket Book yet");
            else System.out.println("Your Tickets: \n");
            for(Ticket t: ticketByMe) System.out.println(t);
        }
        public static void cancelTickets(){
            System.out.println("Enter Ticket ID");
            bookingServices.cancelTicket(sc.nextInt(),userServices.getCurrentUser());

        }

   }
