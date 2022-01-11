package by.zhigalko.jpa.dal.dao;

import by.zhigalko.jpa.dal.entity.BaseEntity;

import java.util.List;

public interface BaseDao<T extends BaseEntity> {
    /**
     * Allow to process data: save, find by id, find all, update, delete entities
     * @param entity
     * @return MessageEntity
     */
    void save(T entity);

    T findById(Long id);

    List<T> findAll();

    void update(T entity);

    void delete(T entity);
}
