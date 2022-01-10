package by.karmyzov.homework5.repsitories;

import by.karmyzov.homework5.entities.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository {
    private final Map<Long, User> database = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(0);
    private static volatile UserRepository instance = new UserRepository();

    private UserRepository() {
        database.put(counter.incrementAndGet(), new User(counter.get(), "Jaromir", "Jagr",
                "jar@gmail.com", "jaga", "111"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Alex", "Oveckin",
                "alexo@gmail.com", "great", "222"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Evgeni", "Kuznetsov",
                "kuzi@gmail.com", "kuzi", "33333"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Vladimir", "Tarasenko",
                "taras@gmail.com", "taras", "344444"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Artemi", "Panarin",
                "panara@gmail.com", "panara", "55555"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Pavel", "Datsuk",
                "dats@gmail.com", "dats", "66666"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Sergei", "Fedorov",
                "fedor@gmail.com", "fedor", "7777"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Igor", "Larionov",
                "igorek@gmail.com", "igirek", "88888"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Evgeni", "Malkin",
                "malpa@gmail.com", "malpa", "9999"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Alex", "Radulov",
                "rada@gmail.com", "rada", "101010101"));
    }

    public static UserRepository getInstance() {
        UserRepository localInstance = instance;
        if (localInstance == null) {
            synchronized (UserRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new UserRepository();
                }
            }
        }
        return localInstance;
    }

    public User getUserFromDB(Long id) {
        return database.get(id);
    }

    public boolean findUserInDB(Long id) {
        return database.containsKey(id);
    }

    public void putUserIntoDB(User user) {
        database.put(counter.incrementAndGet(), user);
    }

    public void deleteUserFromDB(Long id) {
        database.remove(id, database.get(id));
    }

    public void putUserIntoDB(Long id, User user) {
        database.put(id, user);
    }

    public AtomicLong getCounter() {
        return counter;
    }

    public Map<Long, User> getDatabase() {
        return database;
    }
}