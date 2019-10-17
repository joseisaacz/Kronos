
package logic;

public class User {

    private String tempUser;
    private String password;
    private int deparment;

    public User() {
        this.tempUser = null;
        this.password = null;
        this.deparment = -1;
    }

    public User(String tempUser, String password, int deparment) {
        this.tempUser = tempUser;
        this.password = password;
        this.deparment = deparment;
    }

    public String getTempUser() {
        return tempUser;
    }

    public void setTempUser(String tempUser) {
        this.tempUser = tempUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDeparment() {
        return deparment;
    }

    public void setDeparment(int deparment) {
        this.deparment = deparment;
    }

    
}

