package by.zhigalko.jpa.dal.dao;

import by.zhigalko.jpa.dal.entity.MessageEntity;

public class MessageDaoImpl extends BaseDaoImpl<MessageEntity>{
    public MessageDaoImpl() {
        super(MessageEntity.class);
    }
}
