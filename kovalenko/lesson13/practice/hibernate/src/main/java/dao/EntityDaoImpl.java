package dao;

import entity.PaintingEntity;
import org.hibernate.Session;
import service.SessionUtil;

import java.util.List;

public class EntityDaoImpl implements EntityDao{
    public void save(PaintingEntity entity) {
        Session session = SessionUtil.openSession();
        session.getTransaction().begin();
        session.save(entity);
        session.getTransaction().commit();
        session.close();
    }

    public PaintingEntity findOne(Long id) {
        return null;
    }

    public List<PaintingEntity> findAll() {
        return null;
    }

    public void update(PaintingEntity entity) {

    }
}
