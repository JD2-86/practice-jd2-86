package tpc;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "tpc_persistent_employee")
@ToString(callSuper = true)
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "employee_id")),
        @AttributeOverride(name = "firstname", column = @Column(name = "firstname"))
})
public class PersistentEmployee extends EmployeeTpcEntity{
    @Getter
    @Setter
    @Column(name = "start_date")
    private LocalDate startDate;
    @Getter
    @Setter
    @Column(name = "live_date")
    private LocalDate liveDate;
}
