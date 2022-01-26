package by.zhigalko.hibernate.mapping.relationship.dal.dao;

import by.zhigalko.hibernate.mapping.relationship.dal.entity.*;
import by.zhigalko.hibernate.mapping.relationship.util.SessionManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PermissionDaoImplTest {
    private static BaseDao<Permission> permissionDao;

    @BeforeAll
    static void initTestComponent() {
        permissionDao = new PermissionDaoImpl();
    }

    @BeforeEach
    void setUp() {
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        Query query = session.createQuery("DELETE FROM Permission WHERE TRUE");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
    @Test
    void save() {
        //GIVEN
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        user.setEmail("test@test.com");
        user.setFirstName("test");
        user.setLastName("test");
        user.setAge(27);
        user.setBirthday(LocalDate.of(1994,3,23));
        Role role= new Role();
        role.setCode("test");
        role.setDescription("test");
        role.addUser(user);
        Operation operation = new Operation();
        operation.setCode("test");
        operation.setDescription("test description");

        ObjectEntity object = new ObjectEntity();
        object.setCode("777");
        object.setDescription("777");

        Permission expected = new Permission();
        expected.setCode("77P4");
        expected.setDescription("777 description");

        object.addPermission(expected);
        operation.addPermission(expected);
        //WHEN
        permissionDao.save(expected);
        role.addPermission(expected);
        role.addUser(user);
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
        session.close();

        //THEN
        Session session2 = SessionManager.getSession();
        session2.getTransaction().begin();
        Permission actual = session2.find(Permission.class, expected.getId());
        session2.getTransaction().commit();

        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertEquals(expected, actual);
        session2.close();
    }

    @Test
    void findById() {
        //GIVEN
        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        user.setEmail("test@test.com");
        user.setFirstName("test");
        user.setLastName("test");
        user.setAge(27);
        user.setBirthday(LocalDate.of(1994,3,23));
        Role role= new Role();
        role.setCode("test");
        role.setDescription("test");
        role.addUser(user);
        Operation operation = new Operation();
        operation.setCode("test");
        operation.setDescription("test description");
        ObjectEntity object = new ObjectEntity();
        object.setCode("777");
        object.setDescription("777");

        Permission expected = new Permission();
        expected.setCode("77P4");
        expected.setDescription("777 description");

        object.addPermission(expected);
        operation.addPermission(expected);
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(expected);
        session.getTransaction().commit();

        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        //WHEN
        Permission actual = permissionDao.findById(expected.getId());
        //THEN
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertEquals(expected, actual);
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}