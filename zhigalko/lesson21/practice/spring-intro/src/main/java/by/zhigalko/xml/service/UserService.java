package by.zhigalko.xml.service;

import by.zhigalko.xml.model.User;

public interface UserService {
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
