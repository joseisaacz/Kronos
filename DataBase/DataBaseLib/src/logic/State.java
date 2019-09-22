package logic;

public class State {

    private int id;
    private String description;

    public State(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public State() {
    }
        
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    
}
