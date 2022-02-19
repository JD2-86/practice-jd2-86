package by.zhigalko.java.dao;

import by.zhigalko.java.model.User;

/**
 * DAO for User
 */
public interface UserDao {
    /**
     * Find user by email
     * @param email email
     * @return user {@link User}
     */
    User findByEmail(String email);

    /**
     * Find user by username
     * @param username username
     * @return user {@link User}
     */
    User findByUsername(String username);
}
