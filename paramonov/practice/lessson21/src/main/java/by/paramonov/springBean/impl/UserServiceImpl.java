package by.paramonov.springBean.impl;

import by.paramonov.springBean.User;
import by.paramonov.springBean.dao.impl.UserDaoRam;
import by.paramonov.springBean.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDaoRam userDaoRam;
    @Override
    public User searchByEmail(String email) {
        return userDaoRam.searchByEmail(email);
    }

    @Override
    public User searchByUsername(String username) {
        return userDaoRam.searchByUsername(username);
    }
}
