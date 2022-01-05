package by.zhigalko.task6.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EntityStorage {
    private Map<Integer, User> database;
    private AtomicInteger counter = new AtomicInteger(0);

    public EntityStorage() {
        database = new HashMap<>();
        User user1 = new User();
        user1.setName("Alex");
        user1.setSurname("Smith");
        user1.setEmail("alex@smith.com");
        database.put(counter.incrementAndGet(), user1);
        User user2 = new User();
        user2.setName("Tom");
        user2.setSurname("Carrol");
        user2.setEmail("tom@carrol.com");
        database.put(counter.incrementAndGet(), user2);
        User user3 = new User();
        user3.setName("Bill");
        user3.setSurname("Ran");
        user3.setEmail("bill@ran.com");
        database.put(counter.incrementAndGet(), user3);
    }

    public User getUserFromDB(Integer id) {
        return database.get(id);
    }

    public boolean findUserInDB(Integer id) {
        return database.containsKey(id);
    }
}
