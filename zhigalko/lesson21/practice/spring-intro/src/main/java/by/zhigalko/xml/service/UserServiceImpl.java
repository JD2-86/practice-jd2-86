package by.zhigalko.xml.service;

import by.zhigalko.xml.dao.UserDao;
import by.zhigalko.xml.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
