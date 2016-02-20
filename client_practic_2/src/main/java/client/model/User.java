package client.model;

/**
 * Created by Narcis2007 on 18.01.2016.
 */
public class User {

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
