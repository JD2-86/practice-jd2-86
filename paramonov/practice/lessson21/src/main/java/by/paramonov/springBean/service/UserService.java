package by.paramonov.springBean.service;

import by.paramonov.springBean.User;

public interface UserService {
    User searchByEmail(String email);
    User searchByUsername(String username);
}
