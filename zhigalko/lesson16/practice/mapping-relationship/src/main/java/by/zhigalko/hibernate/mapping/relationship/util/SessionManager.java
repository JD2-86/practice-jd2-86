package by.zhigalko.hibernate.mapping.relationship.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionManager {
    private static volatile SessionFactory instance = null;

    public static SessionFactory getInstance() {
        if (instance == null) {
            synchronized (SessionManager.class) {
                if (instance == null) {
                    instance = new Configuration().configure().buildSessionFactory();
                }
            }
        }
        return instance;
    }

    public static Session getSession() {
        return getInstance().openSession();
    }
}
