package by.zhigalko.hibernate.criteria.api.dal.dao;


import by.zhigalko.hibernate.criteria.api.dal.entity.Gender;
import by.zhigalko.hibernate.criteria.api.dal.entity.RoleName;
import by.zhigalko.hibernate.criteria.api.dal.entity.User;
import java.util.List;

public interface UserRoleDao {
    /**
     * Find all users where role
     * @param roleName
     * @return List<User>
     */
    List<User> findUsersByRoleName(RoleName roleName);

    /**
     * Find count users of all roles
     * @return List<Object[]>
     */
    List<Object[]> findCountUsersOfAllRoles();

    /**
     * Find usernames with
     * @param roleName
     * where gender equal
     * @param gender
     * order by username
     * @return List<String>
     */
    List<String> findUsernamesByRoleNameAndGenderOrderByUsername(RoleName roleName, Gender gender);

    /**
     * Find user's first name and last name where roleName equal
     * @param roleName
     */
    List<String[]> findFirstAndLastNameByRoleName(RoleName roleName);
}
