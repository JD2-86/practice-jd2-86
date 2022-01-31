package tpc;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "tpc_employee")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class EmployeeTpcEntity extends BaseEntity{
    @Getter
    @Setter
    @Column(name = "firstname")
    private String firstname;
    @Getter
    @Setter
    @Column(name = "lastname")
    private String lastname;
}
