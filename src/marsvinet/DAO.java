package marsvinet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO {

    private DBConnector connector = null;

    DAO(DBConnector connector) { // hvad er forskellen på, at den er public eller intet nævnt? I TeamWork er intet nævnt
        this.connector = connector;
    }

    public void newMember(String name, int birthday, String active, String elite) {
        try {
            String query = "INSERT INTO `marsvinet`.`members` (`name`, `birthday`, `active`, `elite`) VALUES (?, ?, ?, ?)";
            Connection con = connector.getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setInt(2, birthday);
            pstmt.setString(3, active);
            pstmt.setString(4, elite);
            pstmt.execute();
            con.close();
            System.out.println("New Member added to Database");
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Member getMember(int id_members) {
        try {
            Member member = null;
            String query = "SELECT * FROM members WHERE id_members = " + id_members;
            Connection con = connector.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id_members");
                String name = rs.getString("name");
                int birthday = rs.getInt("birthday");
                String active = rs.getString("active");
                String elite = rs.getString("elite");

                member = new Member(id, name, birthday, active, elite);
            }

            return member;

        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Member> getTeamEliteSenior() {
        try {
            List<Member> members = new ArrayList<>();

            String query = "SELECT * FROM marsvinet.members WHERE birthday <=2000 AND elite = \"true\""; // mangler check for active
            Connection con = connector.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id_members");
                String name = rs.getString("name");
                int birthday = rs.getInt("birthday");
                String active = rs.getString("active");
                String elite = rs.getString("elite");

                Member member = new Member(id, name, birthday, active, elite);

                members.add(member);
            }

            return members;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Member> getMembers() {
        try {
            List<Member> members = new ArrayList<>();

            String query = "SELECT * FROM members";
            Connection con = connector.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id_members");
                String name = rs.getString("name");
                int birthday = rs.getInt("birthday");
                String active = rs.getString("active");
                String elite = rs.getString("elite");

                Member member = new Member(id, name, birthday, active, elite);

                members.add(member);
            }

            return members;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<User> getUsers() {
        try {
            List<User> users = new ArrayList<>();

            String query = "SELECT * FROM users";
            Connection con = connector.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id_users");
                String name = rs.getString("name");
                String password = rs.getString("password");
                String birthday = rs.getString("birthday");
                String role = rs.getString("role");

                User user = new User(id, name, password, birthday, role);
                users.add(user);
            }

            return users;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Team> getTeams() {
        try {
            List<Team> teams = new ArrayList<>();

            String query = "SELECT * FROM teams";
            Connection con = connector.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id_teams");
                String name = rs.getString("name");

                Team team = new Team(id, name);
                teams.add(team);
            }

            return teams;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Category> getCategories() {
        try {
            List<Category> categories = new ArrayList<>();

            String query = "SELECT * FROM categories";
            Connection con = connector.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id = rs.getInt("id_categories");
                String name = rs.getString("name");

                Category category = new Category(id, name);
                categories.add(category);
            }

            return categories;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Result> getResults() {
        try {
            List<Result> results = new ArrayList<>();

            String query = "select results.id_results, results.id_members, results.time, results.place, categories.name from results join categories on results.id_categories = categories.id_categories;";
            Connection con = connector.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                int id_result = rs.getInt("id_results");
                int id_member = rs.getInt("id_members");
                String category = rs.getString("name");
                int time = rs.getInt("time");
                String place = rs.getString("place");
                
                Result result = new Result(id_result, id_member, category, time, place);
                
                results.add(result);
            }

            return results;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }
    
    public List<Result> getTopResultsButterfly() {
        try {
            List<Result> results = new ArrayList<>();
            
            String query = "select results.id_results, results.id_members, results.time, results.place, categories.name from results join categories on results.id_categories = categories.id_categories where results.id_categories = 1  order by results.time asc limit 5";
            Connection con = connector.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                int id_result = rs.getInt("id_results");
                int id_member = rs.getInt("id_members");
                String category = rs.getString("name");
                int time = rs.getInt("time");
                String place = rs.getString("place");
                
                Result result = new Result(id_result, id_member, category, time, place);
                
                results.add(result);
            }
            return results;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public List<Result> getTopResultsCrawl() {
        try {
            List<Result> results = new ArrayList<>();
            
            String query = "select results.id_results, results.id_members, results.time, results.place, categories.name from results join categories on results.id_categories = categories.id_categories where results.id_categories = 2  order by results.time asc limit 5";
            Connection con = connector.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                int id_result = rs.getInt("id_results");
                int id_member = rs.getInt("id_members");
                String category = rs.getString("name");
                int time = rs.getInt("time");
                String place = rs.getString("place");
                
                Result result = new Result(id_result, id_member, category, time, place);
                
                results.add(result);
            }
            return results;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public void updateMember(int id_member, String name, int birthday, String active, String elite) {
        try {
            String query = "UPDATE `marsvinet`.`members` SET `name` = ?, `birthday` = ?, `active` = ?, `elite` = ? WHERE (`id_members` =" +  id_member + ")";
            Connection con = connector.getConnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setInt(2, birthday);
            pstmt.setString(3, active);
            pstmt.setString(4, elite);
            pstmt.execute();
            con.close();
            
            System.out.println("Bruger updateret i database");
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
