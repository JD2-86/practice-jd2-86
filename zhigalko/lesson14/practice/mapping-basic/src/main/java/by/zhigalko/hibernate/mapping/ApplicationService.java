package by.zhigalko.hibernate.mapping;

import by.zhigalko.hibernate.mapping.dal.dao.BaseDao;
import by.zhigalko.hibernate.mapping.dal.dao.EmployeeDaoImpl;
import by.zhigalko.hibernate.mapping.dal.entity.AddressSet;
import by.zhigalko.hibernate.mapping.dal.entity.Employee;
import by.zhigalko.hibernate.mapping.dal.entity.Position;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.*;
import java.util.List;
import java.util.TimeZone;

public class ApplicationService {
    private static final Logger log = LogManager.getLogger(ApplicationService.class);

    public void run() {
        TimeZone.setDefault(TimeZone.getTimeZone(ZoneOffset.UTC));
        BaseDao<Employee> employeeBaseDao = new EmployeeDaoImpl();
        Employee employee = new Employee();
        employee.setFirstName("Alex");
        employee.setLastName("Smith");
        employee.setPosition(Position.SOFTWARE_DEVELOPER);
        employee.setBirthday(LocalDate.ofEpochDay(1990 - 12 - 12));
        employee.setTimeTrackerCheck(ZonedDateTime.now(ZoneOffset.UTC));
        employee.setDailyMeetingBeginning(LocalTime.of(15, 30));
        employee.setDailyMeetingDuration(Duration.parse("PT20M"));
        employee.setHomeAddress(new AddressSet("USA", "NY state", "New York",
                "57Street", "15A"));
        employee.setWorkAddress(new AddressSet("USA", "Texas state", "Austin",
                "Washington street", "132W"));
        employeeBaseDao.save(employee);

        Employee foundEmployee = employeeBaseDao.findById(employee.getId());

        foundEmployee.setFirstName("TOM");
        employeeBaseDao.update(foundEmployee);

        employeeBaseDao.delete(foundEmployee);

        List<Employee> all = employeeBaseDao.findAll();
        all.forEach(log::debug);
    }
}
