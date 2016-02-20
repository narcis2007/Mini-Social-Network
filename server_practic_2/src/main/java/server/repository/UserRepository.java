package server.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import server.model.User;
import server.util.HibernateUtil;

import java.util.logging.Logger;

/**
 * Created by Narcis2007 on 17.01.2016.
 */
@Repository
public class UserRepository {

    SessionFactory sf = HibernateUtil.getSessionFactory();
    private static final Logger log = Logger.getLogger( UserRepository.class.getName() );
    public User getByUsername(String username){
        Session session = sf.openSession();
        User u=(User)session.get(User.class,username);
        session.close();
        return u;
    }
}
