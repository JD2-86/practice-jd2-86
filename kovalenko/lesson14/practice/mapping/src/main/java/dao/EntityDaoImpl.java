package dao;

import entity.EmployeeEntity;
import org.hibernate.Session;
import sevice.SessionUtil;

import java.util.List;

public class EntityDaoImpl implements EntityDao {
    @Override
    public void save(EmployeeEntity entity) {
        Session session = SessionUtil.openSession();
        session.getTransaction().begin();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public EmployeeEntity findOne(Long id) {
        return null;
    }

    @Override
    public List<EmployeeEntity> findAll() {
        return null;
    }

    @Override
    public void update(EmployeeEntity entity) {

    }
}
