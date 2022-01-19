package by.zhigalko.hibernate.mapping.dal.dao;

import by.zhigalko.hibernate.mapping.dal.entity.AddressSet;
import by.zhigalko.hibernate.mapping.dal.entity.Employee;
import by.zhigalko.hibernate.mapping.dal.entity.Position;
import by.zhigalko.hibernate.mapping.util.SessionManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.util.List;
import java.util.TimeZone;

import static java.time.ZoneOffset.UTC;
import static org.junit.jupiter.api.Assertions.*;

class BaseDaoImplTest {
    private static BaseDao<Employee> employeeBaseDao;

    @BeforeAll
    static void initTestComponent() {
        employeeBaseDao = new EmployeeDaoImpl();
        TimeZone.setDefault(TimeZone.getTimeZone(UTC));
    }

    @BeforeEach
    void setUp() {
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        Query query = session.createQuery("DELETE FROM Employee WHERE TRUE");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @Test
    void saveTest() {
        //GIVEN
        Employee expected = new Employee();
        expected.setFirstName("Tony");
        expected.setLastName("Stark");
        expected.setPosition(Position.SOFTWARE_DEVELOPER);
        expected.setBirthday(LocalDate.ofEpochDay(1990 - 12 - 12));
        expected.setTimeTrackerCheck(ZonedDateTime.now(ZoneId.of("UTC")));
        expected.setDailyMeetingBeginning(LocalTime.of(15, 30));
        expected.setDailyMeetingDuration(Duration.parse("PT20M"));
        expected.setHomeAddress(new AddressSet("USA", "NY state", "New York",
                "57Street", "15A"));
        expected.setWorkAddress(new AddressSet("USA", "Texas state", "Austin",
                "Washington street", "132W"));
        //WHEN
        employeeBaseDao.save(expected);
        //THEN
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        Employee actual = session.find(Employee.class, expected.getId());
        session.getTransaction().commit();
        session.close();
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected, actual);
    }

    @Test
    void findByIdTest() {
        //GIVEN
        Employee expected = new Employee();
        expected.setFirstName("Tony");
        expected.setLastName("Stark");
        expected.setPosition(Position.SOFTWARE_DEVELOPER);
        expected.setBirthday(LocalDate.ofEpochDay(1990 - 12 - 12));
        expected.setTimeTrackerCheck(ZonedDateTime.now(ZoneId.of("UTC")));
        expected.setDailyMeetingBeginning(LocalTime.of(15, 30));
        expected.setDailyMeetingDuration(Duration.parse("PT20M"));
        expected.setHomeAddress(new AddressSet("USA", "NY state", "New York",
                "57Street", "15A"));
        expected.setWorkAddress(new AddressSet("USA", "Texas state", "Austin",
                "Washington street", "132W"));
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(expected);
        session.getTransaction().commit();
        session.close();
        //WHEN
        Employee actual = employeeBaseDao.findById(expected.getId());
        //THEN
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected, actual);
    }

    @Test
    void findAllTest() {
        //GIVEN
        Employee employee1 = new Employee();
        employee1.setFirstName("Tony");
        employee1.setLastName("Stark");
        employee1.setPosition(Position.SOFTWARE_DEVELOPER);
        employee1.setBirthday(LocalDate.ofEpochDay(1990 - 12 - 12));
        employee1.setTimeTrackerCheck(ZonedDateTime.now(ZoneId.of("UTC")));
        employee1.setDailyMeetingBeginning(LocalTime.of(15, 30));
        employee1.setDailyMeetingDuration(Duration.parse("PT20M"));
        employee1.setHomeAddress(new AddressSet("USA", "NY state", "New York",
                "57Street", "15A"));
        employee1.setWorkAddress(new AddressSet("USA", "Texas state", "Austin",
                "Washington street", "132W"));
        Employee employee2 = new Employee();
        employee2.setFirstName("Alex");
        employee2.setLastName("SMith");
        employee2.setPosition(Position.SOFTWARE_DEVELOPER);
        employee2.setBirthday(LocalDate.ofEpochDay(1995 - 12 - 15));
        employee2.setTimeTrackerCheck(ZonedDateTime.now(ZoneId.of("UTC")));
        employee2.setDailyMeetingBeginning(LocalTime.of(15, 30));
        employee2.setDailyMeetingDuration(Duration.parse("PT20M"));
        employee2.setHomeAddress(new AddressSet("USA", "NY state", "New York",
                "57Street", "15A"));
        employee2.setWorkAddress(new AddressSet("USA", "Texas state", "Austin",
                "Washington street", "132W"));
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(employee1);
        session.save(employee2);
        session.getTransaction().commit();
        session.close();
        List<Employee> expected = List.of(employee1, employee2);
        //WHEN
        List<Employee> actual = employeeBaseDao.findAll();
        //THEN
        assertNotNull(actual);
        assertEquals(expected.size(),actual.size());
        assertEquals(expected, actual);
    }

    @Test
    void updateTest() {
        //GIVEN
        Employee expected = new Employee();
        expected.setFirstName("Tony");
        expected.setLastName("Stark");
        expected.setPosition(Position.SOFTWARE_DEVELOPER);
        expected.setBirthday(LocalDate.ofEpochDay(1990 - 12 - 12));
        expected.setTimeTrackerCheck(ZonedDateTime.now(ZoneId.of("UTC")));
        expected.setDailyMeetingBeginning(LocalTime.of(15, 30));
        expected.setDailyMeetingDuration(Duration.parse("PT20M"));
        expected.setHomeAddress(new AddressSet("USA", "NY state", "New York",
                "57Street", "15A"));
        expected.setWorkAddress(new AddressSet("USA", "Texas state", "Austin",
                "Washington street", "132W"));
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(expected);
        session.getTransaction().commit();
        session.close();
        //WHEN
        expected.setFirstName("TOMAS");
        employeeBaseDao.update(expected);
        //THEN
        Session session1 = SessionManager.getSession();
        session1.getTransaction().begin();
        Employee actual = session1.find(Employee.class, expected.getId());
        session1.getTransaction().commit();
        session1.close();
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertEquals(expected.getId(), actual.getId());
        assertEquals(expected, actual);
    }

    @Test
    void deleteTest() {
        //GIVEN
        Employee expected = new Employee();
        expected.setFirstName("Tony");
        expected.setLastName("Stark");
        expected.setPosition(Position.SOFTWARE_DEVELOPER);
        expected.setBirthday(LocalDate.ofEpochDay(1990 - 12 - 12));
        expected.setTimeTrackerCheck(ZonedDateTime.now(ZoneId.of("UTC")));
        expected.setDailyMeetingBeginning(LocalTime.of(15, 30));
        expected.setDailyMeetingDuration(Duration.parse("PT20M"));
        expected.setHomeAddress(new AddressSet("USA", "NY state", "New York",
                "57Street", "15A"));
        expected.setWorkAddress(new AddressSet("USA", "Texas state", "Austin",
                "Washington street", "132W"));
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(expected);
        session.getTransaction().commit();
        session.close();
        //WHEN
        employeeBaseDao.delete(expected);
        //THEN
        Session session2 = SessionManager.getSession();
        session2.getTransaction().begin();
        List<Employee> actual = session2.createQuery(String.format("select entity from %s entity",
                Employee.class.getSimpleName()), Employee.class).getResultList();
        session2.getTransaction().commit();
        session2.close();
        assertEquals(0, actual.size());
    }
}
