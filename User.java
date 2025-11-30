public class User {
    private String name;
    private String contact;
    private String password;
    private String username;

    public User(String name, String contact, String password, String username) {
        this.name = name;
        this.contact = contact;
        this.password = password;
        this.username = username;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return name + " ( " + username + " ) ";
    }
}
