package by.shcharbunou.superheroes.repositories.specifications;

public interface Specification<T> {
    boolean isExist(T t);
}
