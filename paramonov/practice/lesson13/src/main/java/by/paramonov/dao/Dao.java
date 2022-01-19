package by.paramonov.dao;

import java.util.List;

public interface Dao<T extends Object> {
    void save();

    T findOne(Long id);

    List<T> findAll();

    void update();

    void delete();

}
