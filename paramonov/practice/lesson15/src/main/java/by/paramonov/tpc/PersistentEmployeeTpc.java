package by.paramonov.tpc;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "tpc_employees")
@ToString(callSuper = true)
@AttributeOverrides({
        @AttributeOverride(name = "id_tpc_employee", column = @Column(name = "contract_employee_id")),
        @AttributeOverride(name = "first_name", column = @Column(name = "first_name")),
        @AttributeOverride(name = "last_name", column = @Column(name = "last_name"))
})
public class PersistentEmployeeTpc extends EmployeeTpc {

    @Getter
    @Setter

    private LocalDate startDate;
    private LocalDate liveDate;
}
