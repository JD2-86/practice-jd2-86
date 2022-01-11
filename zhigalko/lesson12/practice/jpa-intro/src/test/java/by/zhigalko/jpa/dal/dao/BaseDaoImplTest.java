package by.zhigalko.jpa.dal.dao;

import by.zhigalko.jpa.dal.entity.MessageEntity;
import by.zhigalko.jpa.util.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BaseDaoImplTest {
    private static BaseDao<MessageEntity> messageDao;

    @BeforeAll
    static void initDao(){
        messageDao = new MessageDaoImpl();
    }

    @BeforeEach
    void clearDB() {
        EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Query queryClear = entityManager.createQuery("delete from MessageEntity");
        queryClear.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    void saveTest() {
        MessageEntity expected = new MessageEntity("!hello!");
        messageDao.save(expected);
        MessageEntity actual = messageDao.findById(expected.getId());
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertEquals(expected,actual);
    }

    @Test
    void findByIdTest() {
        MessageEntity expected = new MessageEntity("hello!");
        messageDao.save(expected);
        MessageEntity actual = messageDao.findById(expected.getId());
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertEquals(expected, actual);
    }

    @Test
    void findAllTest() {
        MessageEntity message1 = new MessageEntity("hello from junit");
        MessageEntity message2 = new MessageEntity("test");
        messageDao.save(message1);
        messageDao.save(message2);
        List<MessageEntity> expected = List.of(message1, message2);
        List<MessageEntity> actual = messageDao.findAll();
        assertNotNull(actual);
        assertEquals(expected, actual);
        assertEquals(expected.size(),actual.size());
    }

    @Test
    void updateTest() {
        MessageEntity expected = new MessageEntity("test text");
        messageDao.save(expected);
        expected.setText("Ubuntu");
        messageDao.update(expected);
        MessageEntity actual = messageDao.findById(expected.getId());
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void deleteTest() {
        MessageEntity expected = new MessageEntity("test text");
        messageDao.save(expected);
        messageDao.delete(expected);
        List<MessageEntity> actual = messageDao.findAll();
        assertNotNull(actual);
        assertEquals(actual.size(),0);
    }
}
