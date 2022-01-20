package by.zhigalko.hibernate.mapping.inheritance;

import by.zhigalko.hibernate.mapping.inheritance.dal.entity.tpc.ContractTpcEmployee;
import by.zhigalko.hibernate.mapping.inheritance.dal.entity.tpc.PersistentTpcEmployee;
import by.zhigalko.hibernate.mapping.inheritance.dal.entity.tph.ContractTphEmployee;
import by.zhigalko.hibernate.mapping.inheritance.dal.entity.tph.PersistentTphEmployee;
import by.zhigalko.hibernate.mapping.inheritance.dal.entity.tps.ContractTpsEmployee;
import by.zhigalko.hibernate.mapping.inheritance.dal.entity.tps.PersistentTpsEmployee;
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

        ContractTpcEmployee contractTpcEmployee1 = new ContractTpcEmployee();
        contractTpcEmployee1.setFirstName("Alex");
        contractTpcEmployee1.setLastName("Smith");
        contractTpcEmployee1.setContractNumber("3454-EC");
        contractTpcEmployee1.setContractBeginDate(LocalDate.of(2021,12,12));
        contractTpcEmployee1.setContractEndDate(LocalDate.of(2022,12,11));

        ContractTpcEmployee contractTpcEmployee2 = new ContractTpcEmployee();
        contractTpcEmployee2.setFirstName("Tom");
        contractTpcEmployee2.setLastName("Raith");
        contractTpcEmployee2.setContractNumber("2134-EC");
        contractTpcEmployee2.setContractBeginDate(LocalDate.of(2020,5,30));
        contractTpcEmployee2.setContractEndDate(LocalDate.of(2022,5,29));

        ContractTpcEmployee contractTpcEmployee3 = new ContractTpcEmployee();
        contractTpcEmployee3.setFirstName("Selena");
        contractTpcEmployee3.setLastName("Wins");
        contractTpcEmployee3.setContractNumber("15-EC");
        contractTpcEmployee3.setContractBeginDate(LocalDate.of(2021,4,30));
        contractTpcEmployee3.setContractEndDate(LocalDate.of(2022,4,29));

        ContractTpcEmployee contractTpcEmployee4 = new ContractTpcEmployee();
        contractTpcEmployee4.setFirstName("Marcos");
        contractTpcEmployee4.setLastName("Mashog");
        contractTpcEmployee4.setContractNumber("1546-EC");
        contractTpcEmployee4.setContractBeginDate(LocalDate.of(2021,1,7));
        contractTpcEmployee4.setContractEndDate(LocalDate.of(2022,1,6));

        ContractTpcEmployee contractTpcEmployee5 = new ContractTpcEmployee();
        contractTpcEmployee5.setFirstName("Elizabeth");
        contractTpcEmployee5.setLastName("Turns");
        contractTpcEmployee5.setContractNumber("1955-EC");
        contractTpcEmployee5.setContractBeginDate(LocalDate.of(2022,1,7));
        contractTpcEmployee5.setContractEndDate(LocalDate.of(2024,1,6));

        PersistentTpcEmployee persistentTpcEmployee1 = new PersistentTpcEmployee();
        persistentTpcEmployee1.setFirstName("Bernard");
        persistentTpcEmployee1.setLastName("Show");
        persistentTpcEmployee1.setStartDate(LocalDate.of(2019,12,1));
        persistentTpcEmployee1.setLeaveDate(LocalDate.of(2022,11,30));

        PersistentTpcEmployee persistentTpcEmployee2 = new PersistentTpcEmployee();
        persistentTpcEmployee2.setFirstName("Barbara");
        persistentTpcEmployee2.setLastName("South");
        persistentTpcEmployee2.setStartDate(LocalDate.of(2018,5,1));
        persistentTpcEmployee2.setLeaveDate(LocalDate.of(2022,4,30));

        PersistentTpcEmployee persistentTpcEmployee3 = new PersistentTpcEmployee();
        persistentTpcEmployee3.setFirstName("Andy");
        persistentTpcEmployee3.setLastName("North");
        persistentTpcEmployee3.setStartDate(LocalDate.of(2021,1,22));
        persistentTpcEmployee3.setLeaveDate(LocalDate.of(2022,1,1));

        PersistentTpcEmployee persistentTpcEmployee4 = new PersistentTpcEmployee();
        persistentTpcEmployee4.setFirstName("Tom");
        persistentTpcEmployee4.setLastName("West");
        persistentTpcEmployee4.setStartDate(LocalDate.of(2019,1,22));
        persistentTpcEmployee4.setLeaveDate(LocalDate.of(2022,1,1));

        PersistentTpcEmployee persistentTpcEmployee5 = new PersistentTpcEmployee();
        persistentTpcEmployee5.setFirstName("Michael");
        persistentTpcEmployee5.setLastName("Eastern");
        persistentTpcEmployee5.setStartDate(LocalDate.of(2015,1,22));
        persistentTpcEmployee5.setLeaveDate(LocalDate.of(2022,1,1));

        session.save(contractTpcEmployee1);
        session.save(contractTpcEmployee2);
        session.save(contractTpcEmployee3);
        session.save(contractTpcEmployee4);
        session.save(contractTpcEmployee5);

        session.save(persistentTpcEmployee1);
        session.save(persistentTpcEmployee2);
        session.save(persistentTpcEmployee3);
        session.save(persistentTpcEmployee4);
        session.save(persistentTpcEmployee5);

//        ContractTphEmployee contractTphEmployee1 = new ContractTphEmployee();
//        contractTphEmployee1.setFirstName("Alex");
//        contractTphEmployee1.setLastName("Smith");
//        contractTphEmployee1.setContractNumber("3454-EC");
//        contractTphEmployee1.setContractBeginDate(LocalDate.of(2021,12,12));
//        contractTphEmployee1.setContractEndDate(LocalDate.of(2022,12,11));
//
//        ContractTphEmployee contractTphEmployee2 = new ContractTphEmployee();
//        contractTphEmployee2.setFirstName("Tom");
//        contractTphEmployee2.setLastName("Raith");
//        contractTphEmployee2.setContractNumber("2134-EC");
//        contractTphEmployee2.setContractBeginDate(LocalDate.of(2020,5,30));
//        contractTphEmployee2.setContractEndDate(LocalDate.of(2022,5,29));
//
//        ContractTphEmployee contractTphEmployee3 = new ContractTphEmployee();
//        contractTphEmployee3.setFirstName("Selena");
//        contractTphEmployee3.setLastName("Wins");
//        contractTphEmployee3.setContractNumber("15-EC");
//        contractTphEmployee3.setContractBeginDate(LocalDate.of(2021,4,30));
//        contractTphEmployee3.setContractEndDate(LocalDate.of(2022,4,29));
//
//        ContractTphEmployee contractTphEmployee4 = new ContractTphEmployee();
//        contractTphEmployee4.setFirstName("Marcos");
//        contractTphEmployee4.setLastName("Mashog");
//        contractTphEmployee4.setContractNumber("1546-EC");
//        contractTphEmployee4.setContractBeginDate(LocalDate.of(2021,1,7));
//        contractTphEmployee4.setContractEndDate(LocalDate.of(2022,1,6));
//
//        ContractTphEmployee contractTphEmployee5 = new ContractTphEmployee();
//        contractTphEmployee5.setFirstName("Elizabeth");
//        contractTphEmployee5.setLastName("Turns");
//        contractTphEmployee5.setContractNumber("1955-EC");
//        contractTphEmployee5.setContractBeginDate(LocalDate.of(2022,1,7));
//        contractTphEmployee5.setContractEndDate(LocalDate.of(2024,1,6));
//
//        PersistentTphEmployee persistentTphEmployee1 = new PersistentTphEmployee();
//        persistentTphEmployee1.setFirstName("Bernard");
//        persistentTphEmployee1.setLastName("Show");
//        persistentTphEmployee1.setStartDate(LocalDate.of(2019,12,1));
//        persistentTphEmployee1.setLeaveDate(LocalDate.of(2022,11,30));
//
//        PersistentTphEmployee persistentTphEmployee2 = new PersistentTphEmployee();
//        persistentTphEmployee2.setFirstName("Barbara");
//        persistentTphEmployee2.setLastName("South");
//        persistentTphEmployee2.setStartDate(LocalDate.of(2018,5,1));
//        persistentTphEmployee2.setLeaveDate(LocalDate.of(2022,4,30));
//
//        PersistentTphEmployee persistentTphEmployee3 = new PersistentTphEmployee();
//        persistentTphEmployee3.setFirstName("Andy");
//        persistentTphEmployee3.setLastName("North");
//        persistentTphEmployee3.setStartDate(LocalDate.of(2021,1,22));
//        persistentTphEmployee3.setLeaveDate(LocalDate.of(2022,1,1));
//
//        PersistentTphEmployee persistentTphEmployee4 = new PersistentTphEmployee();
//        persistentTphEmployee4.setFirstName("Tom");
//        persistentTphEmployee4.setLastName("West");
//        persistentTphEmployee4.setStartDate(LocalDate.of(2019,1,22));
//        persistentTphEmployee4.setLeaveDate(LocalDate.of(2022,1,1));
//
//        PersistentTphEmployee persistentTphEmployee5 = new PersistentTphEmployee();
//        persistentTphEmployee5.setFirstName("Michael");
//        persistentTphEmployee5.setLastName("Eastern");
//        persistentTphEmployee5.setStartDate(LocalDate.of(2015,1,22));
//        persistentTphEmployee5.setLeaveDate(LocalDate.of(2022,1,1));
//
//        session.save(contractTphEmployee1);
//        session.save(contractTphEmployee2);
//        session.save(contractTphEmployee3);
//        session.save(contractTphEmployee4);
//        session.save(contractTphEmployee5);
//
//        session.save(persistentTphEmployee1);
//        session.save(persistentTphEmployee2);
//        session.save(persistentTphEmployee3);
//        session.save(persistentTphEmployee4);
//        session.save(persistentTphEmployee5);

//        ContractTpsEmployee contractTpsEmployee1 = new ContractTpsEmployee();
//        contractTpsEmployee1.setFirstName("Alex");
//        contractTpsEmployee1.setLastName("Smith");
//        contractTpsEmployee1.setContractNumber("3454-EC");
//        contractTpsEmployee1.setContractBeginDate(LocalDate.of(2021,12,12));
//        contractTpsEmployee1.setContractEndDate(LocalDate.of(2022,12,11));
//
//        ContractTpsEmployee contractTpsEmployee2 = new ContractTpsEmployee();
//        contractTpsEmployee2.setFirstName("Tom");
//        contractTpsEmployee2.setLastName("Raith");
//        contractTpsEmployee2.setContractNumber("2134-EC");
//        contractTpsEmployee2.setContractBeginDate(LocalDate.of(2020,5,30));
//        contractTpsEmployee2.setContractEndDate(LocalDate.of(2022,5,29));
//
//        ContractTpsEmployee contractTpsEmployee3 = new ContractTpsEmployee();
//        contractTpsEmployee3.setFirstName("Selena");
//        contractTpsEmployee3.setLastName("Wins");
//        contractTpsEmployee3.setContractNumber("15-EC");
//        contractTpsEmployee3.setContractBeginDate(LocalDate.of(2021,4,30));
//        contractTpsEmployee3.setContractEndDate(LocalDate.of(2022,4,29));
//
//        ContractTpsEmployee contractTpsEmployee4 = new ContractTpsEmployee();
//        contractTpsEmployee4.setFirstName("Marcos");
//        contractTpsEmployee4.setLastName("Mashog");
//        contractTpsEmployee4.setContractNumber("1546-EC");
//        contractTpsEmployee4.setContractBeginDate(LocalDate.of(2021,1,7));
//        contractTpsEmployee4.setContractEndDate(LocalDate.of(2022,1,6));
//
//        ContractTpsEmployee contractTpsEmployee5 = new ContractTpsEmployee();
//        contractTpsEmployee5.setFirstName("Elizabeth");
//        contractTpsEmployee5.setLastName("Turns");
//        contractTpsEmployee5.setContractNumber("1955-EC");
//        contractTpsEmployee5.setContractBeginDate(LocalDate.of(2022,1,7));
//        contractTpsEmployee5.setContractEndDate(LocalDate.of(2024,1,6));
//
//        PersistentTpsEmployee persistentTpsEmployee1 = new PersistentTpsEmployee();
//        persistentTpsEmployee1.setFirstName("Bernard");
//        persistentTpsEmployee1.setLastName("Show");
//        persistentTpsEmployee1.setStartDate(LocalDate.of(2019,12,1));
//        persistentTpsEmployee1.setLeaveDate(LocalDate.of(2022,11,30));
//
//        PersistentTpsEmployee persistentTpsEmployee2 = new PersistentTpsEmployee();
//        persistentTpsEmployee2.setFirstName("Barbara");
//        persistentTpsEmployee2.setLastName("South");
//        persistentTpsEmployee2.setStartDate(LocalDate.of(2018,5,1));
//        persistentTpsEmployee2.setLeaveDate(LocalDate.of(2022,4,30));
//
//        PersistentTpsEmployee persistentTpsEmployee3 = new PersistentTpsEmployee();
//        persistentTpsEmployee3.setFirstName("Andy");
//        persistentTpsEmployee3.setLastName("North");
//        persistentTpsEmployee3.setStartDate(LocalDate.of(2021,1,22));
//        persistentTpsEmployee3.setLeaveDate(LocalDate.of(2022,1,1));
//
//        PersistentTpsEmployee persistentTpsEmployee4 = new PersistentTpsEmployee();
//        persistentTpsEmployee4.setFirstName("Tom");
//        persistentTpsEmployee4.setLastName("West");
//        persistentTpsEmployee4.setStartDate(LocalDate.of(2019,1,22));
//        persistentTpsEmployee4.setLeaveDate(LocalDate.of(2022,1,1));
//
//        PersistentTpsEmployee persistentTpsEmployee5 = new PersistentTpsEmployee();
//        persistentTpsEmployee5.setFirstName("Michael");
//        persistentTpsEmployee5.setLastName("Eastern");
//        persistentTpsEmployee5.setStartDate(LocalDate.of(2015,1,22));
//        persistentTpsEmployee5.setLeaveDate(LocalDate.of(2022,1,1));
//
//        session.save(contractTpsEmployee1);
//        session.save(contractTpsEmployee2);
//        session.save(contractTpsEmployee3);
//        session.save(contractTpsEmployee4);
//        session.save(contractTpsEmployee5);
//
//        session.save(persistentTpsEmployee1);
//        session.save(persistentTpsEmployee2);
//        session.save(persistentTpsEmployee3);
//        session.save(persistentTpsEmployee4);
//        session.save(persistentTpsEmployee5);

        session.getTransaction().commit();
        session.close();
        log.debug(ContractTpcEmployee.class);
    }
}
