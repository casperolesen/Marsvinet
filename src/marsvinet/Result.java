package marsvinet;

public class Result {
    int id_result;
    int id_member;
    String category;
    String time;
    String place;

    public Result(int id_result, int id_member, String category, String time, String place) {
        this.id_result = id_result;
        this.id_member = id_member;
        this.category = category;
        this.time = time;
        this.place = place;
    }

    public int getId_result() {
        return id_result;
    }

    public void setId_result(int id_result) {
        this.id_result = id_result;
    }

    public int getId_member() {
        return id_member;
    }

    public void setId_member(int id_member) {
        this.id_member = id_member;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    
    
    
    
}
