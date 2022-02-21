package by.paramonov.springBean.dao;

import by.paramonov.springBean.User;

public interface UserDao {
    User searchByEmail(String email);
    User searchByUsername(String username);
}
