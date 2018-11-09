package marsvinet;

public class User {
    int id;
    String name;
    String password;
    String birthday;
    String role;

    public User(int id, String name, String password, String birthday, String role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.birthday = birthday;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    @Override
    public String toString() {
        return id + " " + name + " " + password + " " + birthday + " " + role;
    }
    
    
}
