package by.kovalenko.repo;

import by.kovalenko.model.User;

import java.util.List;

public interface UserRepo {
    List<User> getUsers();
    User add(User user);
    List<User> add(List<User> users);
}
