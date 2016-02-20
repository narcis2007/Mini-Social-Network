package server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerPractic2Application {

	public static void main(String[] args) {

		SpringApplication.run(ServerPractic2Application.class, args);
//		SessionFactory sf = HibernateUtil.getSessionFactory();
//
//		Session session = sf.openSession();
//
//		session.beginTransaction();
//		Post p1=new Post("narcis","hello");
//		Post p2=new Post("admin","world");
//		Post p3=new Post("narcis","post");
//		session.save(p1);
//		session.save(p2);
//		session.save(p3);
//		session.getTransaction().commit();
//		session.close();

	}
}
