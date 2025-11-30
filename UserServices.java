import java.util.HashMap;
import java.util.Map;

public class UserServices {
    private Map<String,User> userMap= new HashMap<>();
    private User currentUser=null;

    public boolean registerUser(String name, String contact, String password, String username){
        if (userMap.containsKey(username)) {
            System.out.println("The username '" + username + "' already exists. Please choose another.");
            return false;
        }
        User user=new User(name,contact,password,username);
        userMap.put(username,user);
        System.out.println("You are SuccesFully Registor on BusBooking Application");
        return true;
    }
    public boolean userLogin(String username,String password){
        if(userMap.containsKey(username)&& userMap.get(username).getPassword().equals(password)){

            currentUser=userMap.get(username);
            System.out.println("Login Succesfully, Welcome "+currentUser.getName());
            return true;
        }
        else {
            System.out.println("Please Check your Username or Password");
            return false;
        }
    }
    public void logoutUser() {
        if (currentUser != null) {
            currentUser=null;
            System.out.println("Logout Succesfully");
        }
    }
    public boolean isLogin(){
        if(currentUser!=null) return true;
        return false;
    }

    public User getCurrentUser() {
        return currentUser;
    }
}
