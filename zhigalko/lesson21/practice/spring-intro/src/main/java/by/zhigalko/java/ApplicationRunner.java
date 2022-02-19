package by.zhigalko.java;

import by.zhigalko.java.model.User;
import by.zhigalko.java.service.UserService;
import by.zhigalko.java.util.ApplicationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class ApplicationRunner {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        User user = userService.findByEmail("alex@smith.com");
        User user2 = userService.findByUsername("tom-s");
        List<User> users = List.of(user, user2);
        users.forEach(System.out::println);
        context.close();
    }
}
