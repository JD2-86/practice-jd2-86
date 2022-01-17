package by.zhigalko.hibernate.dal.dao;

import by.zhigalko.hibernate.dal.entity.Painting;
import by.zhigalko.hibernate.util.SessionManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BaseDaoImplTest {
    private static BaseDao<Painting> paintingBaseDao;

    @BeforeAll
    static void initTestComponent() {
        paintingBaseDao = new PaintingDaoImpl();
    }

    @BeforeEach
    void setUp() {
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        Query query = session.createQuery("DELETE FROM Painting WHERE TRUE");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Test
    void saveTest() {
        //GIVEN
        Painting expected= new Painting(0L, "Sistine madonna", "Rafael Santi");
        //WHEN
        paintingBaseDao.save(expected);
        //THEN
        Painting actual = SessionManager.getSession().find(Painting.class, expected.getId());
        assertNotNull(actual);
    }

    @Test
    void findByIdTest() {
    }

    @Test
    void findAllTest() {
    }

    @Test
    void updateTest() {
    }

    @Test
    void deleteTest() {
    }
}