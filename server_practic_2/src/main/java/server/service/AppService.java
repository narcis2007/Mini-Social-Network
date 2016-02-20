package server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import server.model.Post;
import server.model.User;
import server.repository.PostRepository;
import server.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Narcis2007 on 17.01.2016.
 */
@RestController
public class AppService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    private static final Logger log = Logger.getLogger( AppService.class.getName() );

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public boolean authenticate(@RequestBody Map<String,String> data) {
        String username = data.get("username");
        String password = data.get("password");
        User u=userRepository.getByUsername(username);
        if(u!=null&&u.getPassword().equals(password))
            return true;
        return false;
    }

    @RequestMapping(value = "/addPost", method = RequestMethod.POST)
    public Post addPost(@RequestBody Map<String,String> data) {
        org.springframework.security.core.userdetails.User user1 = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String text = data.get("text");

        return postRepository.save(new Post(user1.getUsername(),text));
    }
    @RequestMapping(value = "/getPosts", method = RequestMethod.GET)
    public List<Post> getPosts() {
        org.springframework.security.core.userdetails.User user1 = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username=user1.getUsername();
        User user=userRepository.getByUsername(username);
        List<Post> posts=new ArrayList<>();
        posts.addAll(postRepository.getPosts(user));
        for(User u:user.getFriendList()){
            posts.addAll(postRepository.getPosts(u));


        }            log.info("getting posts");
        return posts;
    }
}
