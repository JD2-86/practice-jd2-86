package by.paramonov.tpc;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        sessionFactory.close();
    }
}
