package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionUtil {

    private static SessionFactory getInstance(){
        SessionFactory INSTANCE = new Configuration().configure().buildSessionFactory();
        return INSTANCE;
    }

    public static Session openSession(){
        return getInstance().openSession();
    }
}
