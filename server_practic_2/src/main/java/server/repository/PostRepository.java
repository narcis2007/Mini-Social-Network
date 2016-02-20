package server.repository;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import server.model.Post;
import server.model.User;
import server.util.HibernateUtil;

import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Narcis2007 on 17.01.2016.
 */

@Repository
public class PostRepository {
    SessionFactory sf = HibernateUtil.getSessionFactory();
    private static final Logger log = Logger.getLogger( PostRepository.class.getName() );
    public Post save(Post post){
        Session session = sf.openSession();
        session.beginTransaction();

        session.save(post);

        session.getTransaction().commit();
        session.close();
        return post;
    }

    public List<Post> getPosts(User user){
        Session session = sf.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Post where username= :username");
        query.setParameter("username", user.getUsername());
        List posts=query.list();
        session.getTransaction().commit();
        session.close();
        return posts;
    }

}
