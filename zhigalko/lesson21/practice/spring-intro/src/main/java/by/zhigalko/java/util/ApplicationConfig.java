package by.zhigalko.java.util;

import by.zhigalko.java.dao.UserDao;
import by.zhigalko.java.dao.UserDaoImpl;
import by.zhigalko.java.model.User;
import by.zhigalko.java.service.UserService;
import by.zhigalko.java.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("by.zhigalko.java")
public class ApplicationConfig {
    @Bean
    public List<User> users() {
        List<User> usersList = new ArrayList<>();
        usersList.add(new User("alex","smith", "alex@smith.com", "alex-s","qwerty"));
        usersList.add(new User("tom","soyer", "tom@soyer.com", "tom-s","qwerty123213"));
        usersList.add(new User("mary","supp", "mary@supp.com", "mary-s","!123qwerty"));
        return usersList;
    }

    @Bean("userDao")
    public UserDao userDao(){
        return new UserDaoImpl(users());
    }

    @Bean("userService")
    public UserService userService() {
        return new UserServiceImpl(userDao());
    }
}
