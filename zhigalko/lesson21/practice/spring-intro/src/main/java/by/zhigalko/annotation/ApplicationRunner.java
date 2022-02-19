package by.zhigalko.annotation;

import by.zhigalko.annotation.model.User;
import by.zhigalko.annotation.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.List;

public class ApplicationRunner {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-annotation.xml");
        UserService userService = context.getBean("userService", UserService.class);
        User user = userService.findByEmail("alex@smith.com");
        User user2 = userService.findByUsername("tom-s");
        List<User> users = List.of(user, user2);
        users.forEach(System.out::println);
        context.close();
    }
}
