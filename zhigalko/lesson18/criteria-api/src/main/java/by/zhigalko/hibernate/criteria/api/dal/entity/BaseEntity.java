package by.zhigalko.hibernate.criteria.api.dal.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private UUID id;
}
