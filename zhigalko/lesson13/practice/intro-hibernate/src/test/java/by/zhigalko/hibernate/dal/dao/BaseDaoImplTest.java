package by.zhigalko.hibernate.dal.dao;

import by.zhigalko.hibernate.dal.entity.Painting;
import by.zhigalko.hibernate.util.SessionManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        Session session = SessionManager.getSession();
        Painting actual = session.find(Painting.class, expected.getId());
        session.close();
        assertNotNull(actual);
        assertEquals(expected,actual);
    }

    @Test
    void findByIdTest() {
        //GIVEN
        Session session = SessionManager.getSession();
        Painting expected= new Painting(0L, "Sistine madonna", "Rafael Santi");
        session.save(expected);
        session.close();
        //WHEN
        Painting actual = paintingBaseDao.findById(expected.getId());
        //THEN
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertEquals(expected, actual);
    }

    @Test
    void findAllTest() {
        //GIVEN
        Painting painting1 = new Painting(0L, "Malevich square", "Kazimir Malevich");
        Painting painting2 = new Painting(1L, "Sistine madonna", "Rafael Santi");
        Session session = SessionManager.getSession();
        session.save(painting1);
        session.save(painting2);
        session.close();
        List<Painting> expected = List.of(painting1, painting2);
        //WHEN
        List<Painting> actual = paintingBaseDao.findAll();
        //THEN
        assertNotNull(actual);
        assertEquals(expected.size(),actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void updateTest() {
        //GIVEN
        Painting expected = new Painting(0L, "Malevich square", "Kazimir Malevich");
        Session session = SessionManager.getSession();
        session.save(expected);
        //WHEN
        expected.setName("TEST");
        paintingBaseDao.update(expected);
        //THEN
        Painting actual = session.find(Painting.class, expected.getId());
        session.close();
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertEquals(expected, actual);
    }

    @Test
    void deleteTest() {
        //GIVEN
        Painting expected = new Painting(0L, "Malevich square", "Kazimir Malevich");
        Session session = SessionManager.getSession();
        session.save(expected);
        session.close();
        //WHEN
        paintingBaseDao.delete(expected);
        //THEN
        Session session1 = SessionManager.getSession();
        List<Painting> actual = session1.createQuery(String.format("select entity from %s entity",
                Painting.class.getSimpleName()), Painting.class).getResultList();
        session1.close();
        assertEquals(0, actual.size());
    }
}
