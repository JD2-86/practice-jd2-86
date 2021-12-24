package by.kovalenko.service.impl;

import by.kovalenko.exception.UserNotFoundException;
import by.kovalenko.model.User;
import by.kovalenko.repo.UserRepo;
import by.kovalenko.repo.impl.UserRepoImpl;
import by.kovalenko.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepo usersRepo = UserRepoImpl.getInstance();
    private static final UserService INSTANCE = new UserServiceImpl();

    public User add(User user) {
        return usersRepo.add(user);
    }

    public List<User> add(List<User> users) {
        return usersRepo.add(users);
    }

    @Override
    public User getById(Long id) {
        return usersRepo.getUsers().stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> getUsersPartition(Integer page, Integer pageSize) {
        List<User> users = usersRepo.getUsers();
        int firsIndex = (page - 1) * pageSize;
        int lastIndex = firsIndex + pageSize;
        lastIndex = Math.min(lastIndex, users.size());
        return users.subList(firsIndex, lastIndex);
    }

    public List<User> getUsers() {
        return usersRepo.getUsers();
    }

    private UserServiceImpl() {
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}
