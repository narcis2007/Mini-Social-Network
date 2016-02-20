package client.service;

import client.model.Post;
import client.model.User;
import org.apache.http.HttpHost;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Narcis2007 on 18.01.2016.
 */
public class AppClient {

    private static AppClient client;
    public static final String URL = "http://localhost:8080/";
    private final HttpHost host = new HttpHost("localhost", 8080, "http");
    private User user;

    private RestTemplate restTemplate = new RestTemplate();
    private AuthHttpComponentsClientHttpRequestFactory requestFactory;

    private AppClient(){
        requestFactory=new AuthHttpComponentsClientHttpRequestFactory(host,user);
        restTemplate = new RestTemplate(requestFactory);
    }

    public static AppClient getEmailClient() {
        if(client==null)
            return new AppClient();
        return client;
    }

    public Boolean authenticate(String username, String password) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("username",username);
        vars.put("password",password);

        boolean authenticated=restTemplate.postForObject(URL+"authenticate",vars,Boolean.class);
        if(authenticated) {
            user = new User(username, password);
            requestFactory.setUser(user);
        }
        return authenticated;
    }

    public Post[] getPosts() {
        return restTemplate.getForObject(URL+"getPosts",Post[].class);
    }

    public Post addPost(String text) {
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("text",text);

        return restTemplate.postForObject(URL+"addPost",vars,Post.class);
    }
}
