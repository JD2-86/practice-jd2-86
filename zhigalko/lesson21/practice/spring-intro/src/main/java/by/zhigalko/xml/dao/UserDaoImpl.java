package by.zhigalko.xml.dao;

import by.zhigalko.xml.model.User;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UserDaoImpl implements UserDao{
    private List<User> users;

    public UserDaoImpl() {}

    public UserDaoImpl(List<User> users) {
        this.users=users;
    }

    @Override
    public User findByEmail(String email) {
        return users.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public User findByUsername(String username) {
        return users.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .orElseThrow(RuntimeException::new);
    }
}
