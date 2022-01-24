package by.zhigalko.hibernate.mapping.relationship.dal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
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
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private UUID id;
}
