package by.zhigalko.hibernate.mapping.inheritance.dal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@ToString
public abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "id")
    private UUID id;
}
