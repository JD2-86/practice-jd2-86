package by.zhigalko.hibernate.mapping.inheritance.dal.entity.tph;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.DiscriminatorValue;
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
@DiscriminatorValue("contract_employee")
public class ContractTphEmployee extends EmployeeTph {
    @Column(name = "contract_number")
    private String contractNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "contract_begin_date")
    private LocalDate contractBeginDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "contract_end_date")
    private LocalDate contractEndDate;
}