package by.zhigalko.annotation.dao;

import by.zhigalko.annotation.model.User;

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
