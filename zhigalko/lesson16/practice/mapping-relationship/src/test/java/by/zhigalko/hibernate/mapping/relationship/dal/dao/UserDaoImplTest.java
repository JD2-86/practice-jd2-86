package by.zhigalko.hibernate.mapping.relationship.dal.dao;

import by.zhigalko.hibernate.mapping.relationship.dal.entity.*;
import by.zhigalko.hibernate.mapping.relationship.util.SessionManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class UserDaoImplTest {
    private static BaseDao<User> userDao;

   @BeforeAll
    static void initTestComponent() {
        userDao = new UserDaoImpl();
    }

    @BeforeEach
    void setUp() {
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        Query query = session.createQuery("DELETE FROM User WHERE TRUE");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Test
    void saveTest() {
        //GIVEN
        User expected = new User();
        expected.setUsername("test");
        expected.setPassword("test");
        expected.setEmail("test@test.com");
        expected.setFirstName("test");
        expected.setLastName("test");
        expected.setAge(27);
        expected.setBirthday(LocalDate.of(1994,3,23));
        Role role= new Role();
        role.setCode("test");
        role.setDescription("test");
        role.addUser(expected);
        //WHEN
        userDao.save(expected);
        //THEN
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        User actual = session.find(User.class, expected.getId());
        session.getTransaction().commit();
        session.close();
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertEquals(expected, actual);
    }

    @Test
    void findByIdTest() {
        //GIVEN
        User expected = new User();
        expected.setUsername("test");
        expected.setPassword("test");
        expected.setEmail("test@test.com");
        expected.setFirstName("test");
        expected.setLastName("test");
        expected.setAge(27);
        expected.setBirthday(LocalDate.of(1994,3,23));

        Role role= new Role();
        role.setCode("test");
        role.setDescription("test");
        role.addUser(expected);
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(expected);
        session.getTransaction().commit();
        session.close();
        //WHEN
        User actual = userDao.findById(expected.getId());
        //THEN
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertEquals(expected, actual);
    }

    @Test
    void findAllTest() {
        //GIVEN
        User expected1 = new User();
        expected1.setUsername("test");
        expected1.setPassword("test");
        expected1.setEmail("test@test.com");
        expected1.setFirstName("test");
        expected1.setLastName("test");
        expected1.setAge(27);
        expected1.setBirthday(LocalDate.of(1994,3,23));

        Role role1= new Role();
        role1.setCode("test");
        role1.setDescription("test");
        role1.addUser(expected1);
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(expected1);
        session.getTransaction().commit();
        session.close();
        User expected2 = new User();
        expected2.setUsername("test2");
        expected2.setPassword("test2");
        expected2.setEmail("test2@test.com");
        expected2.setFirstName("test2");
        expected2.setLastName("test2");
        expected2.setAge(27);
        expected2.setBirthday(LocalDate.of(1994,3,23));

        Role role2= new Role();
        role2.setCode("user2");
        role2.setDescription("user2");
        role2.addUser(expected2);
        Session session2 = SessionManager.getSession();
        session2.getTransaction().begin();
        session2.save(expected2);
        session2.getTransaction().commit();
        session2.close();
        List<User> expected = List.of(expected1, expected2);

        //WHEN
        List<User> actual = userDao.findAll();
        //THEN
        assertNotNull(actual);
        assertEquals(expected.size(),actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void updateTest() {
        //GIVEN
        User expected = new User();
        expected.setUsername("test");
        expected.setPassword("test");
        expected.setEmail("test@test.com");
        expected.setFirstName("test");
        expected.setLastName("test");
        expected.setAge(27);
        expected.setBirthday(LocalDate.of(1994,3,23));

        Role role= new Role();
        role.setCode("test");
        role.setDescription("test");
        role.addUser(expected);
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(expected);
        session.getTransaction().commit();
        session.close();

        expected.setFirstName("Alex");
        expected.setLastName("Smith");
        //WHEN
        userDao.update(expected);
        //THEN
        Session session2 = SessionManager.getSession();
        session2.getTransaction().begin();
        User actual = session2.find(User.class, expected.getId());
        session2.getTransaction().commit();
        session2.close();
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertEquals(expected, actual);
    }

    @Test
    void deleteTest() {
        //GIVEN
        User expected = new User();
        expected.setUsername("test");
        expected.setPassword("test");
        expected.setEmail("test@test.com");
        expected.setFirstName("test");
        expected.setLastName("test");
        expected.setAge(27);
        expected.setBirthday(LocalDate.of(1994,3,23));
        Role role= new Role();
        role.setCode("test");
        role.setDescription("test");
        role.addUser(expected);
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(expected);
        session.getTransaction().commit();
        session.close();
        //WHEN
        userDao.delete(expected);
        //THEN
        Session session2 = SessionManager.getSession();
        session2.getTransaction().begin();
        List<User> actual = session2.createQuery(String.format("select entity from %s entity",
                User.class.getSimpleName()), User.class).getResultList();
        session2.getTransaction().commit();
        session2.close();
        assertEquals(0, actual.size());
    }
}
