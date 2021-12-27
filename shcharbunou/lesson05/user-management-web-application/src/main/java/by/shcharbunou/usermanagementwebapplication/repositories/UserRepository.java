package by.shcharbunou.usermanagementwebapplication.repositories;

import by.shcharbunou.usermanagementwebapplication.entities.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class UserRepository {
    private final Map<Long, User> database = new HashMap<>();
    private final AtomicLong counter = new AtomicLong(0);
    private static volatile UserRepository instance = new UserRepository();

    private UserRepository() {
        database.put(counter.incrementAndGet(), new User(counter.get(), "Vladimir", "Putin",
                "vvputin@yandex.ru", "vovan_1952", "4321fuckbiden1234"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Joe", "Biden",
                "joebiden@gmail.com", "joeshuewithlove", "2021_fuckputin_2021"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Robert", "Preston",
                "robertpr@gmail.com", "rob_pres_2001", "securitylevel9999"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Elizabeth", "Horn",
                "elhorn@gmail.com", "Horny_Lizzy", "imgonnakillpeople"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Henry", "Murphy",
                "hhmurphy@gmail.com", "MorpheousGuy", "chooseYourPILL"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Olivia", "Bates",
                "olivia_bates@gmail.com", "X_mamina-olivka_X", "mypassword12345678"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Anna", "Fisher",
                "annochka-fish@gmail.com", "_ProfessionalFisher_", "ihackedcolonialpipeline"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Spencer", "Greer",
                "ggspence@gmail.com", "GreerCareer", "user0987654321resu"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "Adele", "Parks",
                "adelepark@gmail.com", "ParksLovesLSDMarks", "hydraruzxpnew4af"));
        database.put(counter.incrementAndGet(), new User(counter.get(), "John", "Woods",
                "johnywood@gmail.com", "Big_Black_Backwood", "killpeoplekillall"));
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
