package by.zhigalko.hibernate.mapping.inheritance.dal.entity.tps;

import by.zhigalko.hibernate.mapping.inheritance.dal.entity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.Table;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tps_employees")
public abstract class EmployeeTps extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}