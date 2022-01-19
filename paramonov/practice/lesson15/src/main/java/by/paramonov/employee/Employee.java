package by.paramonov.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;


public abstract class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private UUID employeeID;

    @Getter
    @Setter
    private String firstName;
    @Getter
    @Setter
    private String lastName;
}
