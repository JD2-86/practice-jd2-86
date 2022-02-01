package by.zhigalko.hibernate.criteria.api.dal.dao;

import by.zhigalko.hibernate.criteria.api.dal.entity.User;
import java.util.List;

public interface UserDao {

    /**
     * Save entity into data source
     * @param user
     */
    void save(User user);

    /**
     * Find all entities from data source
     * @return
     */
    List<User> findAll();

    /**
     * Find entity by email in data source
     * @param email
     * @return
     */
    List<User> findByEmail(String email);

    /**
     * Count entity number in data source
     * @return
     */
    Long findCountAllUsers();

    /**
     * Find entity where height greater than @param height, weight between @param minWeight and @param maxWeight
     * , users's first name like @param firstName
     */
    List<User> findUserByHeightWeightFirstname(Integer height, Integer minWeight, Integer maxWeight, String firstName);

    /**
     * Find username's where @param firstName or @param lastName are not null order by username
     */
     List<String> findUsernameByFirstNameAndLastname();

    /**
     * Find average user's height, where weight greater than @param weight
     */
    Double findAvgUserHeightWeight(Double weight);
}
