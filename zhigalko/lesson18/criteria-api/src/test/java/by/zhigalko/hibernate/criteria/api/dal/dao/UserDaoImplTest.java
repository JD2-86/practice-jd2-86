package by.zhigalko.hibernate.criteria.api.dal.dao;

import by.zhigalko.hibernate.criteria.api.dal.entity.Gender;
import by.zhigalko.hibernate.criteria.api.dal.entity.Role;
import by.zhigalko.hibernate.criteria.api.dal.entity.RoleName;
import by.zhigalko.hibernate.criteria.api.dal.entity.User;
import by.zhigalko.hibernate.criteria.api.util.SessionManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static by.zhigalko.hibernate.criteria.api.dal.entity.RoleName.ADMIN;
import static by.zhigalko.hibernate.criteria.api.dal.entity.RoleName.USER;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;


class UserDaoImplTest {
    private static UserDaoImpl userDao;

    @BeforeAll
    static void initTestComponent() {
        userDao = new UserDaoImpl();
    }

    @BeforeEach
    void setUp() {
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        Query query = session.createQuery("delete from User where true");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @AfterAll
    static void closeSessionFactory() {
        SessionManager.closeSession();
    }

    @Test
    void saveTest() {
        //GIVEN
        User expected = getUser("alex-ii");
        //WHEN
        userDao.save(expected);
        //THEN
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        User actual = session.find(User.class, expected.getId());
        session.getTransaction().commit();
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertEquals(expected, actual);
        session.close();
    }


    @Test
    void findAllTest() {
        //GIVEN
        User user1 = getUser("alex-i");
        User user2 = getUser("tom-to");
        User user3 = getUser("elizabeth-t");
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.getTransaction().commit();
        session.close();
        List<User> expected = List.of(user1, user2, user3);
        //WHEN
        List<User> actual = userDao.findAll();
        //THEN
        assertNotNull(actual);
        assertEquals(expected.size(),actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void findByEmailTest() {
        //GIVEN
        User user = getUser("alex");
        List<User> expected = List.of(user);
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
        session.close();
        //WHEN
        List<User> actual = userDao.findByEmail("test@test.com");
        //THEN
        assertNotNull(actual);
        assertNotEquals(0, actual.size());
        assertEquals(expected.size(), actual.size());
        assertEquals(expected.get(0).getEmail(),actual.get(0).getEmail());
        assertEquals(expected, actual);
    }

    @Test
    void findCountAllUsersTest() {
        //GIVEN
        User user1 = getUser("alex-i");
        User user2 = getUser("tom-to");
        User user3 = getUser("elizabeth-t");
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.getTransaction().commit();
        session.close();
        //WHEN
        Long actual = userDao.findCountAllUsers();
        //THEN
        assertNotNull(actual);
        assertNotEquals(0L, actual);
        assertEquals(3L, actual);
    }

    @Test
    void findUserByHeightAndFirstnameOrderByGenderTest() {
        //GIVEN
        User user1 = getUser("alex-i");
        user1.setFirstName("alex");
        user1.setUserWeight(81.0);
        User user2 = getUser("tom-to");
        user2.setFirstName("tom");
        User user3 = getUser("tomas-t");
        user3.setFirstName("tomas");
        user3.setUserWeight(75.0);
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.getTransaction().commit();
        //WHEN
        List<User> actual = userDao.findUserByHeightWeightFirstname(185, 60, 80, "tom%");
        //THEN
        assertEquals(2L, actual.size());
    }

    @Test
    void findUsernameByFirstNameAndLastnameTest() {
        //GIVEN
        User user1 = getUser("alex-i");
        user1.setFirstName("alex");
        User user2 = getUser("tom-to");
        User user3 = getUser("elizabeth-t");
        user3.setFirstName("elizabeth");
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.getTransaction().commit();
        //WHEN
        List<String> actual = userDao.findUsernameByFirstNameAndLastname();
        //THEN
        assertEquals(2L, actual.size());
        assertNotNull(actual);
    }

    @Test
    void findAvgUserHeightWeightTest() {
        //GIVEN
        User user1 = getUser("alex-i");
        user1.setFirstName("alex");
        user1.setUserHeight(175);
        user1.setUserWeight(86.0);
        user1.setGender(Gender.MALE);
        User user2 = getUser("tom-to");
        User user3 = getUser("elizabeth-t");
        user3.setFirstName("elizabeth");
        user3.setUserHeight(168);
        user3.setUserWeight(56.0);
        user3.setGender(Gender.FEMALE);
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.getTransaction().commit();
        List<User> users = List.of(user1, user2, user3);
        Double expected = users.stream()
                .mapToDouble(User::getUserHeight)
                .filter(value -> value > 50.0)
                .average()
                .orElse(0.0);
        //WHEN
        Double actual = userDao.findAvgUserHeightWeight(50.0);
        //THEN
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    void findUsersByRoleTest(){
        //GIVEN
        User user1 = getUser("alex-i");
        User user2 = getUser("tom-to");
        User user3 = getUser("elizabeth-t");
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.getTransaction().commit();
        List<User> expected = List.of(user1, user2, user3);
        //WHEN
        List<User> actual = userDao.findUsersByRoleName(USER);
        //THEN
        assertNotNull(actual);
        assertEquals(3L, actual.size());
        assertEquals(expected.size(), actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void findCountUsersOfAllRolesTest(){
        //GIVEN
        User user1 = getUser("alex-i");
        User user2 = getUser("tom-to");
        User user3 = getUser("elizabeth-t");
        User user4 = new User();
        Role role= new Role();
        role.setRoleName(ADMIN);
        role.addUser(user4);
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.save(user4);
        session.getTransaction().commit();
        //WHEN
        List<Object[]> actual = userDao.findCountUsersOfAllRoles();
        //THEN
        List<RoleName> roleNames = actual.stream()
                .map(value -> (RoleName) value[0]).collect(toList());
        boolean adminContains = roleNames.contains(ADMIN);
        boolean userContains = roleNames.contains(USER);
        assertEquals(2, roleNames.size());
        assertTrue(adminContains);
        assertTrue(userContains);
        assertEquals(ADMIN, roleNames.get(0));
        assertEquals(USER, roleNames.get(1));
        List<Long> list = actual.stream()
                .map(value -> (Long) value[1]).collect(toList());
        assertEquals(1, list.get(0));
        assertEquals(3, list.get(1));
    }
    @Test
    void findUsernamesByRoleNameAndGenderOrderByUsername() {
        //GIVEN
        User user1 = getUser("alex-i");
        User user2 = getUser("tom-to");
        User user3 = getUser("kate342-t");
        user3.setGender(Gender.FEMALE);
        User user4 = getUser("alice0435");
        user4.setGender(Gender.FEMALE);
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.save(user4);
        session.getTransaction().commit();
        //WHEN
        List<String> actual = userDao.findUsernamesByRoleNameAndGenderOrderByUsername(USER, Gender.FEMALE);
        //THEN
        assertNotNull(actual);
        assertEquals(2L,actual.size());
        actual.forEach(System.out::println);
    }

    @Test
    void findFirstAndLastNameByRoleNameAndSmallestHeight() {
        //GIVEN
        Role role= new Role();
        role.setRoleName(ADMIN);
        User user1 = getUser("alex-i");
        role.addUser(user1);
        user1.setFirstName("Alex");
        user1.setLastName("Alexson");
        User user2 = getUser("tom-to");
        user2.setFirstName("Tom");
        user2.setLastName("Tomasson");
        User user3 = getUser("kate342-t");
        user3.setFirstName("Kate");
        user3.setLastName("Kateson");
        User user4 = getUser("alice0435");
        user4.setFirstName("Alice");
        user4.setLastName("Aliceson");
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(user1);
        session.save(user2);
        session.save(user3);
        session.save(user4);
        session.getTransaction().commit();
        //WHEN
        List<String[]> actual = userDao.findFirstAndLastNameByRoleName(USER);
        //THEN
        assertNotNull(actual);
        String[] s1  = new String[] {"Tom", "Tomasson"};
        String[] s2  = new String[] {"Kate", "Kateson"};
        String[] s3  = new String[] {"Alice", "Aliceson"};
        List<String[]> expected = List.of(s1, s2, s3);
        assertEquals(Arrays.toString(s1),Arrays.toString(actual.get(0)));
        assertEquals(Arrays.toString(s2),Arrays.toString(actual.get(1)));
        assertEquals(Arrays.toString(s3),Arrays.toString(actual.get(2)));
    }

    @NotNull
    private User getUser(String username) {
        User expected = new User();
        expected.setUsername(username);
        expected.setPassword("test");
        expected.setEmail("test@test.com");
        expected.setGender(Gender.MALE);
        expected.setUserHeight(186);
        expected.setUserWeight(70.0);
        Role role= new Role();
        role.setRoleName(USER);
        role.addUser(expected);
        return expected;
    }
}