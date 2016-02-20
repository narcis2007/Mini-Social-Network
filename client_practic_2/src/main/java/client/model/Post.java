package client.model;

/**
 * Created by Narcis2007 on 18.01.2016.
 */
public class Post {
    public Post(){

    }

    private String username;

    public String getText() {
        return text;
    }

    public String getUsername() {
        return username;
    }

    private String text;

    public Post(String username, String text){

        this.username = username;
        this.text = text;
    }

    @Override
    public String toString() {
        return username + " : " + text ;
    }
}
