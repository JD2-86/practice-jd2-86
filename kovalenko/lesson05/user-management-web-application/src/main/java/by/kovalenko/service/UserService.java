package by.kovalenko.service;

import by.kovalenko.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();
    User add(User user);
    List<User> add(List<User> users);
    User getById(Long id);

    List<User> getUsersPartition(Integer page, Integer pageSize);
}
