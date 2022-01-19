package by.zhigalko.hibernate.mapping.inheritance.dal.entity.tpc;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.AttributeOverride;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tpc_persistent_employee")
@AttributeOverrides({
        @AttributeOverride(name="id",column = @Column(name = "id")),
        @AttributeOverride(name="first_name",column = @Column(name = "first_name")),
        @AttributeOverride(name="last_name",column = @Column(name = "last_name")),
})
public class PersistentTpcEmployee extends Employee{
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private LocalDate startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "leave_date")
    private LocalDate leaveDate;
}
