package server.model;


import javax.persistence.*;
import java.util.List;

/**
 * Created by Narcis2007 on 17.01.2016.
 */
@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    public User(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public User() {

    }
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "friends", joinColumns = {
            @JoinColumn(name = "username", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "friend",
                    nullable = false, updatable = false) })
    public List<User> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<User> friendList) {
        this.friendList = friendList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "friends", joinColumns = {
            @JoinColumn(name = "username", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "friend",
                    nullable = false, updatable = false) })
    private List<User> friendList;
}
