package by.paramonov.tpc;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@MappedSuperclass
@ToString(callSuper = true)
@Table(name = "tpc_employees")
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class EmployeeTpc {
    @Id
    @Column(name = "id_tpc_employee")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private UUID employeeID;

    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstName;
    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastName;
}
