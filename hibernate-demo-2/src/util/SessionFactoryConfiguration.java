package util;

import java.awt.print.Book;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.BookEntity;
import entity.Laptop;
import entity.Student;
import entity.SubjectEntity;

public class SessionFactoryConfiguration {

    private static SessionFactoryConfiguration sessionFactoryConfiguration;

    private SessionFactory sessionFactory;

    private SessionFactoryConfiguration() {
        Configuration configuration = new Configuration().configure().addAnnotatedClass(Laptop.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(BookEntity.class)
                .addAnnotatedClass(SubjectEntity.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactoryConfiguration getInstance() {
        return sessionFactoryConfiguration == null ? sessionFactoryConfiguration = new SessionFactoryConfiguration()
                : sessionFactoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

}