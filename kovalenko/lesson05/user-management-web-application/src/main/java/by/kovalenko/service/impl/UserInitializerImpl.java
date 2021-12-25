package by.kovalenko.service.impl;

import by.kovalenko.model.User;
import by.kovalenko.service.UserInitializer;
import by.kovalenko.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class UserInitializerImpl implements UserInitializer {
    private final UserService usersService = UserServiceImpl.getInstance();
    private final AtomicBoolean isInit = new AtomicBoolean();
    private static final UserInitializer INSTANCE = new UserInitializerImpl();

    @Override
    public int init() {
        List<User> users = new ArrayList<>();
        if (isInit.compareAndSet(false, true)) {
            for (int i = 0; i < 10; i++) {
                users.add(new User("Ivan" + (i + 1), "Ivanov" + (i + 1), "Ivanov" + (i + 1) + "@gmail.com", "userIvan" + (i + 1), "123"));
            }
            usersService.add(users);
        }
        return users.size();
    }

    private UserInitializerImpl() {
    }

    public static UserInitializer getInstance() {
        return INSTANCE;
    }
}
