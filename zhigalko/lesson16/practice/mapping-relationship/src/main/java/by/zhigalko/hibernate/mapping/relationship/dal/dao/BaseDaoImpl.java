package by.zhigalko.hibernate.mapping.relationship.dal.dao;

import by.zhigalko.hibernate.mapping.relationship.dal.entity.BaseEntity;
import by.zhigalko.hibernate.mapping.relationship.util.SessionManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import java.util.List;
import java.util.UUID;

public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T>{
    private final Class<T> iClass;

    public BaseDaoImpl(Class<T> iClass) {
        this.iClass = iClass;
    }

    @Override
    public void save(T entity) {
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public T findById(UUID id) {
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        T entity = session.find(iClass, id);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    @Override
    public List<T> findAll() {
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        TypedQuery<T> typedQuery = session.createQuery(String.format("select entity from %s entity",
                iClass.getSimpleName()), iClass);
        session.getTransaction().commit();
        List<T> resultList = typedQuery.getResultList();
        session.close();
        return resultList;
    }

    @Override
    public void update(T entity) {
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.merge(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void delete(T entity) {
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.delete(entity);
        session.getTransaction().commit();
        session.close();
    }
}