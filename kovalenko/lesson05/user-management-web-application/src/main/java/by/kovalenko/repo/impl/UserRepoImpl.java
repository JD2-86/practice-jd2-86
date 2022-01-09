package by.kovalenko.repo.impl;

import by.kovalenko.model.User;
import by.kovalenko.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepoImpl implements UserRepo {
    private final List<User> users = new ArrayList<>();
    private final AtomicLong idProvider = new AtomicLong();
    private static final UserRepo INSTANCE = new UserRepoImpl();

    public User add(User user) {
        Long id = idProvider.incrementAndGet();
        user.setId(id);
        users.add(user);
        return user;
    }

    public List<User> add(List<User> users) {
        users.forEach(user -> user.setId(idProvider.incrementAndGet()));
        this.users.addAll(users);
        return users;
    }

    public List<User> getUsers() {
        return users;
    }

    private UserRepoImpl() {
    }

    public static UserRepo getInstance() {
        return INSTANCE;
    }
}
