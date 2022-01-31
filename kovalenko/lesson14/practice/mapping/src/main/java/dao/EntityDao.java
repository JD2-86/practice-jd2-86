package dao;

import entity.EmployeeEntity;

import java.util.List;

public interface EntityDao {
    void save(EmployeeEntity entity);

    EmployeeEntity findOne(Long id);

    List<EmployeeEntity> findAll();

    void update(EmployeeEntity entity);
}
