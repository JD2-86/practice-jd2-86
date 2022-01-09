package by.shcharbunou.superheroes.repositories;

import by.shcharbunou.superheroes.repositories.specifications.Specification;

import java.util.Map;

public interface Repository<T> {
    void add(T t);
    void add(Long id, T t);
    T get(Long id);
    boolean find(Long id);
    Map<Long, T> getAll();
    Map<Long, T> findBySpecification(Specification specification);
    void update(T oldT, T newT);
    void remove(long id);
}
