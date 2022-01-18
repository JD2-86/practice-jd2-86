package by.zhigalko.hibernate.dal.dao;

import by.zhigalko.hibernate.dal.entity.BaseEntity;
import java.util.List;

public interface BaseDao <T extends BaseEntity> {
    /**
     * Allow to process data: save, find by id, find all, update, delete entities
     * @param entity
     * @return entity
     */
    void save(T entity);

    T findById(Long id);

    List<T> findAll();

    void update(T entity);

    void delete(T entity);
}
