package by.zhigalko.jpa;

import by.zhigalko.jpa.dal.dao.BaseDaoImpl;
import by.zhigalko.jpa.dal.dao.MessageDaoImpl;
import by.zhigalko.jpa.dal.entity.BaseEntity;
import by.zhigalko.jpa.dal.entity.MessageEntity;
import by.zhigalko.jpa.util.EntityManagerFactoryUtil;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        BaseEntity message1 = new MessageEntity("hello world!");
        BaseEntity message2 = new MessageEntity("hello developer!");
        BaseDaoImpl<MessageEntity> messageDao = new MessageDaoImpl();
        EntityManagerFactoryUtil.init("EclipseLink");
        messageDao.save(message1);
        messageDao.save(message2);

        MessageEntity messageById = messageDao.findById(151L);
        System.out.println(messageById);

        List<MessageEntity> all = messageDao.findAll();
        all.forEach(System.out::println);
        messageById.setText("UPDATE ENTITY DATA");
        messageDao.update(messageById);

        messageDao.delete(messageById);

        EntityManagerFactoryUtil.close();
    }
}
