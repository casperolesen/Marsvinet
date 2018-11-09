package marsvinet;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TUI {
    public static void main(String[] args) throws Exception {
        DBConnector c = new DBConnector();
        DAO data = new DAO(c);
        
        //data.newMember("Test 1", 1900, "Active 1", "Elite 1");
        
        System.out.println("Member with id #1");
        System.out.println(data.getMember(1));
        System.out.println("");
        
        System.out.println("Results");
        System.out.println(data.getResults());
        System.out.println("");
        
        System.out.println("Elite Senior");
        System.out.println(data.getTeamEliteSenior());
        System.out.println("");
        
        System.out.println("Members");
        System.out.println(data.getMembers());
        System.out.println("");
//        for (Member member : data.getMembers()) {
//            System.out.println(member);
//        }
        
        System.out.println("Users");
        System.out.println(data.getUsers());
        System.out.println("");
//        for (User user : data.getUsers()) {
//            System.out.println(user);
//        }
        
        System.out.println("Categories");
        System.out.println(data.getCategories());
        System.out.println("");
//        for (Category category : data.getCategories()) {
//            System.out.println(category);
//        }
        
        System.out.println("Teams");
        System.out.println(data.getTeams());
        System.out.println("");
//        for (Team team : data.getTeams()) {
//            System.out.println(team);
//        }
    }
}
