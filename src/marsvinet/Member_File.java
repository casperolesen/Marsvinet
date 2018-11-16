package marsvinet;

import java.time.LocalDate;

public class Member_File {
    private int id;
    private String name;
    private String email;
    private LocalDate birthday;
    private boolean active;
    private boolean elite;

    public Member_File(int id, String name, String email, LocalDate birthday, boolean active, boolean elite) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
        this.active = active;
        this.elite = elite;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isElite() {
        return elite;
    }

    public void setElite(boolean elite) {
        this.elite = elite;
    }
    
    public String toString() {
        return id + " " + name + " " + birthday + " " + active + " " + elite;
    }
    
    
}
