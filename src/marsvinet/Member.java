
package marsvinet;

public class Member {
    int id;
    String name;
    int birthday;
    String active;
    String elite;

    public Member(int id, String name, int birthday, String active, String elite) {
        this.id = id;
        this.name = name;
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

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getElite() {
        return elite;
    }

    public void setElite(String elite) {
        this.elite = elite;
    }
    
    @Override
    public String toString() {
        return id + " " + name + " " + birthday + " " + active + " " + elite;
    }
    
}
