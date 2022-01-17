package by.zhigalko.hibernate.mapping;

import by.zhigalko.hibernate.mapping.dal.entity.Employee;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApplicationService {
    private static final Logger log = LogManager.getLogger(ApplicationService.class);

    public void run() {
        Employee employee = new Employee();
        log.debug(employee);
    }
}
