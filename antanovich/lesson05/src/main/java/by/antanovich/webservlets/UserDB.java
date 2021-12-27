package by.antanovich.webservlets;

import java.util.HashMap;
import java.util.Map;

public class UserDB {

    private final Map<Long, User> userdb = new HashMap<>();
    private static Long id = 10L;

    public UserDB() {
        User u1 = new User("Vasilii", "Tamello", "vasilisk@yahoo.com", "vasilisk37", "qwerty");
        User u2 = new User("John", "Daw", "johnny@ya.com", "jo", "asdfg12");
        User u3 = new User("Mary", "Smith", "marys@yahoo.com", "margaret", "zxcvbn76");
        User u4 = new User("Omar", "Bill", "omar@bill.com", "thebest", "yuiop6y2");
        User u5 = new User("Selesty", "Rustol", "selery@yahoo.com", "selesty", "hjklg63v");
        User u6 = new User("Henry", "Ford", "hf@gmal.com", "ford", "vbnmc482");
        User u7 = new User("Dallas", "Road", "roading@yahoo.com", "frog7", "zcbml19");
        User u8 = new User("Worren", "Lind", "13@gmail.com", "lindy", "adgjl84");
        User u9 = new User("Alex", "Kapica", "alex@yahoo.com", "alesha", "qetup36");
        User u10= new User("Nikolas", "Fly", "nick@fly.com", "nikolas", "lhdwb45");
        userdb.put(1L, u1);
        u1.setId(1L);
        userdb.put(2L, u2);
        u2.setId(2L);
        userdb.put(3L, u3);
        u3.setId(3L);
        userdb.put(4L, u4);
        u4.setId(4L);
        userdb.put(5L, u5);
        u5.setId(5L);
        userdb.put(6L, u6);
        u6.setId(6L);
        userdb.put(7L, u7);
        u7.setId(7L);
        userdb.put(8L, u8);
        u8.setId(8L);
        userdb.put(9L, u9);
        u9.setId(9L);
        userdb.put(10L, u10);
        u10.setId(10L);
    }

    public void addNewUser(User user) {
        userdb.put(++id, user);
        user.setId(id);
    }

    public boolean findUserById(Long id) {
        return userdb.containsKey(id);
    }

    public User getUserById(Long id) {
        return userdb.get(id);
    }

    public Map<Long, User> getDatabase() {
        return userdb;
    }
}
