package by.zhigalko.hibernate.dal.dao;

import by.zhigalko.hibernate.dal.entity.BaseEntity;
import by.zhigalko.hibernate.util.SessionManager;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import java.util.List;

public class BaseDaoImpl <T extends BaseEntity> implements BaseDao<T>{
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
    }

    @Override
    public T findById(Long id) {
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        T entity = session.find(iClass, id);
        session.getTransaction().commit();
        return entity;
    }

    @Override
    public List<T> findAll() {
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        TypedQuery<T> typedQuery = session.createQuery(String.format("select entity from %s entity",
                iClass.getSimpleName()), iClass);
        session.getTransaction().commit();
        return typedQuery.getResultList();
    }

    @Override
    public void update(T entity) {
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.merge(entity);
        session.getTransaction().commit();
    }

    @Override
    public void delete(T entity) {
        Session session = SessionManager.getSession();
        session.getTransaction().begin();
        session.delete(entity);
        session.getTransaction().commit();
    }
}
