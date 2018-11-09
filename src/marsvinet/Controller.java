package marsvinet;

public class Controller {
    
    public boolean login(String username, String password) {
        String uname = "admin";
        String pword = "1234";
        
        return uname.equals(username) && pword.equals(password);
    }
}
