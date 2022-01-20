package by.zhigalko.hibernate.mapping.inheritance.dal.entity.tps;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
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
@Table(name = "tps_contract_employee")
@PrimaryKeyJoinColumn(name = "id")
public class ContractTpsEmployee extends EmployeeTps {
    @Column(name = "contract_number")
    private String contractNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "contract_begin_date")
    private LocalDate contractBeginDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "contract_end_date")
    private LocalDate contractEndDate;
}
