package by.zhigalko.hibernate.mapping.relationship;

import by.zhigalko.hibernate.mapping.relationship.dal.dao.*;
import by.zhigalko.hibernate.mapping.relationship.dal.entity.*;
import by.zhigalko.hibernate.mapping.relationship.util.SessionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.LocalDate;
import java.util.List;

public class Application {
    private static final Logger log = LogManager.getLogger(Application.class);

    public void run() {
        Role roleUser = new Role();
        roleUser.setCode("test");
        roleUser.setDescription("test");

        User user = new User();
        user.setUsername("test");
        user.setPassword("test");
        user.setEmail("test@test.com");
        user.setFirstName("test");
        user.setLastName("test");
        user.setAge(27);
        user.setBirthday(LocalDate.of(1994,3,23));

        BaseDao<User> userDao = new UserDaoImpl();
//        userDao.delete(user);
//        user.setAge(35);
//        user.setFirstName("Tom");
//        userDao.update(user);
//        log.debug(user);
//        List<User> userList = userDao.findAll();
//        userList.forEach(log::debug);

        BaseDao<Permission> permissionDao = new PermissionDaoImpl();

        Operation operation = new Operation();
        operation.setCode("test");
        operation.setDescription("test description");

        ObjectEntity object = new ObjectEntity();
        object.setCode("777");
        object.setDescription("777");

        Permission permission = new Permission();
        permission.setCode("77P4");
        permission.setDescription("777 description");

        object.addPermission(permission);
        operation.addPermission(permission);

        permissionDao.save(permission);
        SessionManager.getSession().close();
        roleUser.addPermission(permission);
        roleUser.addUser(user);
        userDao.save(user);
        userDao.delete(user);
        permissionDao.delete(permission);
        log.debug(user);
   }
}
