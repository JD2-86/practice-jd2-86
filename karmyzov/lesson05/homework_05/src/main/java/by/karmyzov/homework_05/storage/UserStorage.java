package by.karmyzov.homework_05.storage;

import by.karmyzov.homework_05.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class UserStorage {
    private final Map<Long, User> database;
    private AtomicLong counter = new AtomicLong(0);

    public UserStorage() {
        database = new HashMap<>();
        database.put(counter.incrementAndGet(), new User(counter.get(), "Alex", "Smith",
                "alex@smith.com", "alex_s", "qazwsxedc"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "James", "Brown",
                "james@browm.com", "james_b", "qwerty123"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Edwart", "West",
                "edwar@west.com", "edwart_w", "123pass123"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Marshall", "Gomez",
                "marshall@gomez.com", "marshall_g", "1password1"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "William", "Sherman",
                "william@sherman.com", "wil_sher", "pass123321"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Bill", "East",
                "bill@east.com", "bill_east", "mypass123"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Alfred", "Thompson",
                "alfred@thompson.com", "alfred_t", "123456789"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Bryan", "Norton",
                "bryan@norton.com", "bryan-n", "pass1pass"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Kate", "Tera",
                "kate@tera.com", "kate-t", "password1"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Mary", "Myers",
                "mary@myers.com", "mary_m", "qwer123"));
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