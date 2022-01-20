package by.zhigalko.hibernate.mapping.inheritance.dal.entity.tpc;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@Table(name = "tpc_contract_employee")
public class ContractTpcEmployee extends EmployeeTpc {
    @Column(name = "contract_number")
    private String contractNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "contract_begin_date")
    private LocalDate contractBeginDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "contract_end_date")
    private LocalDate contractEndDate;
}
