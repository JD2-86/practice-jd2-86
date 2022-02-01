package by.zhigalko.hibernate.criteria.api.dal.dao;

import by.zhigalko.hibernate.criteria.api.dal.entity.Gender;
import by.zhigalko.hibernate.criteria.api.dal.entity.Role;
import by.zhigalko.hibernate.criteria.api.dal.entity.RoleName;
import by.zhigalko.hibernate.criteria.api.dal.entity.User;
import by.zhigalko.hibernate.criteria.api.util.SessionManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao, UserRoleDao {
    @Override
    public void save(User user) {
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public List<User> findAll() {
        Session session = SessionManager.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> user = criteria.from(User.class);
        criteria.select(user);
        session.getTransaction().begin();
        TypedQuery<User> query = session.createQuery(criteria);
        session.getTransaction().commit();
        return query.getResultList();
    }

    @Override
    public List<User> findByEmail(String email) {
        Session session = SessionManager.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> user = criteria.from(User.class);
        Path<Object> userEmail = user.get("email");
        criteria.select(user)
                .where(cb.equal(userEmail, email));
        session.getTransaction().begin();
        List<User> list = session.createQuery(criteria).getResultList();
        session.getTransaction().commit();
        return list;
    }

    public Long findCountAllUsers() {
        Session session = SessionManager.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
        Root<User> user = criteria.from(User.class);
        criteria.select(cb.count(user.get("id")));
        session.getTransaction().begin();
        Long result = session.createQuery(criteria).getSingleResult();
        session.getTransaction().commit();
        return result;
    }

    @Override
    public List<User> findUserByHeightWeightFirstname(Integer height, Integer minWeight, Integer maxWeight, String firstName) {
        Session session = SessionManager.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> user = criteria.from(User.class);
        criteria.select(user)
                .where(cb.and(
                        cb.gt(user.get("userHeight"), height)),
                        cb.like(user.get("firstName"), firstName),
                        cb.between(user.get("userWeight"), minWeight,maxWeight));
        session.getTransaction().begin();
        List<User> users = session.createQuery(criteria).getResultList();
        session.getTransaction().commit();
        return users;
    }

    @Override
    public List<String> findUsernameByFirstNameAndLastname() {
        Session session = SessionManager.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<String> criteria = cb.createQuery(String.class);
        Root<User> user = criteria.from(User.class);
        criteria.select(user.get("username"))
                .where(cb.or(
                        cb.isNotNull(user.get("firstName")),
                        cb.isNotNull(user.get("lastName"))))
                .orderBy(cb.desc(user.get("username")));
        session.getTransaction().begin();
        List<String> list = session.createQuery(criteria).getResultList();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public Double findAvgUserHeightWeight(Double weight) {
        Session session = SessionManager.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Double> criteria = cb.createQuery(Double.class);
        Root<User> user = criteria.from(User.class);
        criteria.select(cb.avg(user.get("userHeight")))
                .where(cb.gt(user.get("userWeight"), weight));
        session.getTransaction().begin();
        Double result = session.createQuery(criteria).getSingleResult();
        session.getTransaction().commit();
        return result;
    }

    @Override
    public List<User> findUsersByRoleName(RoleName roleName) {
        Session session = SessionManager.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> user = criteria.from(User.class);
        Join<User, Role> userRole = user.join("role");
        Path<Role> userRoleName = userRole.get("roleName");
        criteria.select(user)
                .where(cb.equal(userRoleName, roleName));
        session.getTransaction().begin();
        List<User> list = session.createQuery(criteria).getResultList();
        session.getTransaction().commit();
        return list;
    }

    @Override
    public List<Object[]> findCountUsersOfAllRoles() {
        Session session = SessionManager.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = cb.createQuery(Object[].class);
        Root<User> user = criteria.from(User.class);
        Join<User, Role> userRole = user.join("role");
        Path<Role> userRoleName = userRole.get("roleName");
        Expression<Long> roleCount = cb.count(user.get("role"));
        criteria.multiselect(userRoleName, roleCount)
                .groupBy(userRoleName);
        session.getTransaction().begin();
        List<Object[]> resultList = session.createQuery(criteria).getResultList();
        session.getTransaction().commit();
        return resultList;
    }

    @Override
    public List<String> findUsernamesByRoleNameAndGenderOrderByUsername(RoleName roleName, Gender gender) {
        Session session = SessionManager.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<String> criteria = cb.createQuery(String.class);
        Root<User> user = criteria.from(User.class);
        Join<Object, Object> role = user.join("role");
        Path<Object> userRoleName = role.get("roleName");
        Predicate predicateRoles = cb.equal(userRoleName, roleName);
        Predicate predicateGender = cb.equal(user.get("gender"), gender);
        criteria.select(user.get("username"))
                .where(predicateRoles, predicateGender)
                .orderBy(cb.asc(user.get("username")));
        session.getTransaction().begin();
        List<String> resultList = session.createQuery(criteria).getResultList();
        session.getTransaction().commit();
        return resultList;
    }

    @Override
    public List<String[]> findFirstAndLastNameByRoleName(RoleName roleName) {
        Session session = SessionManager.getSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<String[]> criteria = cb.createQuery(String[].class);
        Root<User> user = criteria.from(User.class);
        Join<User, Role> userRole = user.join("role");
        Path<Role> userRoleName = userRole.get("roleName");
        Predicate predicateRoles = cb.equal(userRoleName, roleName);
        Predicate predicateEmailIsNotNull = cb.isNotNull(user.get("email"));
        Path<String> firstName = user.get("firstName");
        Path<String> lastName = user.get("lastName");
        criteria.multiselect(firstName,lastName)
                .where(predicateRoles, predicateEmailIsNotNull);
        session.getTransaction().begin();
        List<String[]> resultList = session.createQuery(criteria).getResultList();
        session.getTransaction().commit();
        return resultList;
    }
}
