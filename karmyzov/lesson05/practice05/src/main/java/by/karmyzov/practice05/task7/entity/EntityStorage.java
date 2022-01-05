package by.karmyzov.practice05.task7.entity;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EntityStorage {
    private Map<Integer, User> database;
    private AtomicInteger counter = new AtomicInteger(0);

    public EntityStorage() {
        database = new HashMap<>();
    }

    public User getUserFromDB(Integer id) {
        return database.get(id);
    }

    public boolean findUserInDB(Integer id) {
        return database.containsKey(id);
    }

    public void putUserToDB(User user) {
        database.put(counter.incrementAndGet(), user);
    }
}