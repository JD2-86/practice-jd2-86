package by.kovalenko.service.impl;

import by.kovalenko.model.User;
import by.kovalenko.repo.UserRepo;
import by.kovalenko.repo.impl.UserRepoImpl;
import by.kovalenko.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepo usersRepo = UserRepoImpl.getInstance();
    private static final UserService INSTANCE = new UserServiceImpl();

    public User add(User user){
        return usersRepo.add(user);
    }

    public List<User> add(List<User> users){
       return usersRepo.add(users);
    }

    public List<User> getUsers(){
        return usersRepo.getUsers();
    }

    private UserServiceImpl() {
    }

    public static UserService getInstance(){
        return INSTANCE;
    }
}
