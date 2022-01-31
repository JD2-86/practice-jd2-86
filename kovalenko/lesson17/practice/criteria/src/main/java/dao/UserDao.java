package dao;

import entity.UserEntity;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;

import java.util.List;

public class UserDao {
    private static UserDao INSTANCE;

    private UserDao(){}

    public static UserDao getInstance(){
        if(INSTANCE == null){
            synchronized (UserDao.class){
                if(INSTANCE == null){
                    INSTANCE = new UserDao();
                }
            }
        }
        return INSTANCE;
    }

    public List<UserEntity> findAllByEmailEndComOrRu(Session session, String email){
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<UserEntity> criteria = criteriaBuilder.createQuery(UserEntity.class);
        Root<UserEntity> user = criteria.from(UserEntity.class);
        Predicate email1 = criteriaBuilder.like(user.get("email"), "%.com");
        Predicate email2 = criteriaBuilder.like(user.get("email"), "%.ru");
        criteria.select(user).where(criteriaBuilder.or(email1, email2));
        return session.createQuery(criteria).getResultList();
    }
}
