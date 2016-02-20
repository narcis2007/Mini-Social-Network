package server.model;

import javax.persistence.*;

/**
 * Created by Narcis2007 on 17.01.2016.
 */
@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String username;

    public Post(String username, String text) {

        this.username = username;
        this.text = text;
    }

    public Post() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name="text")
    private String text;
}
