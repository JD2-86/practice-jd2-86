package by.paramonov.springBean.dao.impl;

import by.paramonov.springBean.User;
import by.paramonov.springBean.dao.UserDao;

import java.util.List;

public class UserDaoRam implements UserDao {


    private List<User> userList;

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public User searchByEmail(String email) {
        return userList.stream().filter(x -> x.getEmail().equals(email)).findFirst().get();
    }

    @Override
    public User searchByUsername(String username) {
        return userList.stream().filter(x -> x.getUsername().equals(username)).findFirst().get();
    }
}
