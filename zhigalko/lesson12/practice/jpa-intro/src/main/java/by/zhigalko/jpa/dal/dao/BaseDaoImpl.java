package by.zhigalko.jpa.dal.dao;

import by.zhigalko.jpa.dal.entity.BaseEntity;
import by.zhigalko.jpa.util.EntityManagerFactoryUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T> {
    private final Class<T> clazz;

    public BaseDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void save(BaseEntity entity) {
        EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public T findById(Long id) {
        EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        T entity = entityManager.find(clazz, id);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public List<T> findAll() {
        EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        TypedQuery<T> query = entityManager.createQuery(String.format("select entity from %s entity",
                clazz.getSimpleName()), clazz);
        entityManager.getTransaction().commit();
        return query.getResultList();
    }

    @Override
    public void update(T entity) {
        EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(T entity) {
        EntityManager entityManager = EntityManagerFactoryUtil.getEntityManager();
        entityManager.getTransaction().begin();
        BaseEntity merge = entityManager.merge(entity);
        entityManager.remove(merge);
        entityManager.getTransaction().commit();
    }
}
