package by.paramonov.dao;



import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

@NoArgsConstructor
public class PaintingDao implements Dao {
    SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();


    @Override
    public void save() {

    }

    @Override
    public Object findOne(Long id) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
