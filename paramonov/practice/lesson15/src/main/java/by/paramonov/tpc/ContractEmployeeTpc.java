package by.paramonov.tpc;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.metamodel.mapping.EntityAssociationMapping;

import java.time.LocalDate;

@Entity
@Table(name = "tpc_employees")
@ToString(callSuper = true)
@AttributeOverrides({
        @AttributeOverride(name = "id_tpc_employee", column = @Column(name = "contract_employee_id")),
        @AttributeOverride(name = "first_name", column = @Column(name = "first_name")),
        @AttributeOverride(name = "last_name", column = @Column(name = "last_name"))
})
public class ContractEmployeeTpc extends EmployeeTpc {
    @Getter
    @Setter
    @Column(name = "contract_number")
    private int contractNumber;
    @Getter
    @Setter
    @Column(name = "contract_begin_date")
    private LocalDate contractBeginDate;
    @Getter
    @Setter
    @Column(name = "contract_end_date")
    private LocalDate contractEndDate;
}
