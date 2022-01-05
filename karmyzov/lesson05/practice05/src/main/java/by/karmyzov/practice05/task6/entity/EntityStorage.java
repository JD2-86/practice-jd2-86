package by.karmyzov.practice05.task6.entity;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EntityStorage {
    private Map<Integer, User> database;
    private AtomicInteger counter = new AtomicInteger(0);

    public EntityStorage() {
        database = new HashMap<>();
        User user1 = new User();
        user1.setName("Next");
        user1.setSurname("Nextovich");
        user1.setEmail("next@next.com");
        database.put(counter.incrementAndGet(), user1);
        User user2 = new User();
        user2.setName("Prev");
        user2.setSurname("Prevovoich");
        user2.setEmail("prev@prev.com");
        database.put(counter.incrementAndGet(), user2);
        User user3 = new User();
        user3.setName("Last");
        user3.setSurname("Lastovich");
        user3.setEmail("last@last.com");
        database.put(counter.incrementAndGet(), user3);
    }

    public User getUserFromDB(Integer id) {
        return database.get(id);
    }

    public boolean findUserInDB(Integer id) {
        return database.containsKey(id);
    }
}