package by.zhigalko.hibernate.mapping.relationship.dal.dao;

import by.zhigalko.hibernate.mapping.relationship.dal.entity.User;

public class UserDaoImpl extends BaseDaoImpl<User> {
    public UserDaoImpl(){
        super(User.class);
    }
}
