package tpc;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "tpc_contract_employee")
@ToString(callSuper = true)
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "employee_id")),
        @AttributeOverride(name = "firstname", column = @Column(name = "firstname"))
})
public class ContractEmployee extends EmployeeTpcEntity{
    @Getter
    @Setter
    @Column(name = "contract_number")
    private String contractNumber;
    @Getter
    @Setter
    @Column(name = "contract_begin_date")
    private LocalDate contractBeginDate;
    @Getter
    @Setter
    @Column(name = "contract_end_date")
    private LocalDate contractEndDate;
}
