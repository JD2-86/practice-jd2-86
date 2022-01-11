package by.zhigalko.jpa.dal.entity;

public abstract class BaseEntity {
    private Long id;

    public BaseEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
