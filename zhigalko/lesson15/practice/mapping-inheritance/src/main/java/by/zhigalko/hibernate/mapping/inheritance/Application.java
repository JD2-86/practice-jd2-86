package by.zhigalko.hibernate.mapping.inheritance;

import by.zhigalko.hibernate.mapping.inheritance.dal.entity.tpc.ContractTpcEmployee;
import by.zhigalko.hibernate.mapping.inheritance.util.SessionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import java.time.LocalDate;

public class Application {
    private static final Logger log = LogManager.getLogger(Application.class);

    public void run(){
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        ContractTpcEmployee employee1 = new ContractTpcEmployee();
        employee1.setFirstName("Alex");
        employee1.setLastName("Smith");
        employee1.setContractNumber("3454-EC");
        employee1.setContractBeginDate(LocalDate.of(2021,12,12));
        employee1.setContractEndDate(LocalDate.of(2022,12,11));

        ContractTpcEmployee employee2 = new ContractTpcEmployee();
        employee2.setFirstName("Tom");
        employee2.setLastName("Raith");
        employee2.setContractNumber("2134-EC");
        employee2.setContractBeginDate(LocalDate.of(2020,5,30));
        employee2.setContractEndDate(LocalDate.of(2022,5,29));

        ContractTpcEmployee employee3 = new ContractTpcEmployee();
        employee3.setFirstName("Selena");
        employee3.setLastName("Wins");
        employee3.setContractNumber("15-EC");
        employee3.setContractBeginDate(LocalDate.of(2021,4,30));
        employee3.setContractEndDate(LocalDate.of(2022,4,29));

        ContractTpcEmployee employee4 = new ContractTpcEmployee();
        employee4.setFirstName("Marcos");
        employee4.setLastName("Mashog");
        employee4.setContractNumber("1546-EC");
        employee4.setContractBeginDate(LocalDate.of(2021,1,7));
        employee4.setContractEndDate(LocalDate.of(2022,1,6));

        ContractTpcEmployee employee5 = new ContractTpcEmployee();
        employee5.setFirstName("Elizabeth");
        employee5.setLastName("Turns");
        employee5.setContractNumber("1955-EC");
        employee5.setContractBeginDate(LocalDate.of(2022,1,7));
        employee5.setContractEndDate(LocalDate.of(2024,1,6));

        session.save(employee1);
        session.save(employee2);
        session.save(employee3);
        session.save(employee4);
        session.save(employee5);

        session.getTransaction().commit();
        session.close();
        log.debug(ContractTpcEmployee.class);
    }
}
