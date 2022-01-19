package by.zhigalko.hibernate.mapping.dal.dao;

import by.zhigalko.hibernate.mapping.dal.entity.BaseEntity;

import java.util.List;
import java.util.UUID;

public interface BaseDao <T extends BaseEntity> {
    /**
     * Allow to process data: save, find by id, find all, update, delete entities
     * @param entity
     * @return entity
     */
    void save(T entity);

    T findById(UUID id);

    List<T> findAll();

    void update(T entity);

    void delete(T entity);
}
