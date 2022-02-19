package by.zhigalko.annotation.dao;

import by.zhigalko.annotation.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component("userDao")
@Getter
@Setter
public class UserDaoImpl implements UserDao {
    private List<User> users;

    public UserDaoImpl() {}

    @Autowired
    public UserDaoImpl(List<User> users) {
        this.users=users;
        users.add(new User("alex","smith", "alex@smith.com", "alex-s","qwerty"));
        users.add(new User("tom","soyer", "tom@soyer.com", "tom-s","qwerty123213"));
        users.add(new User("mary","supp", "mary@supp.com", "mary-s","!123qwerty"));
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
