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
        if (isInit.compareAndSet(false, true)){
            List<User> users = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                users.add(new User("Ivan" + i, "Ivanov" + i, "Ivanov" + i + "@gmail.com", "userIvan" + i, "123"));
            }
            usersService.add(users);
            return users.size();
        }
        return 0;
    }

    private UserInitializerImpl() {
    }

    public static UserInitializer getInstance(){
        return INSTANCE;
    }
}
