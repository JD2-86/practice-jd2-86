package dao;

import entity.PaintingEntity;

import java.util.List;

public interface EntityDao {
    void save(PaintingEntity entity);

    PaintingEntity findOne(Long id);

    List<PaintingEntity> findAll();

    void update(PaintingEntity entity);
}
