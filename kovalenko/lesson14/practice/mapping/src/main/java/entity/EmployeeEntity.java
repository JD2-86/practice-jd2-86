package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private Enum position;

    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private LocalDate birthday;

    @Column(name = "timeTrackerCheck")
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime timeTrackerCheck;

    @Column(name = "dailyMeetingBeginning")
    @Temporal(TemporalType.TIME)
    private LocalTime dailyMeetingBeginning;

    @Column(name = "dailyMeetingDuration")
    @Temporal(TemporalType.TIME)
    private LocalTime dailyMeetingDuration;

    @Column(name = "homeAddress")
    private String homeAddress;

    @Column(name = "workAddress")
    private String workAddress;
}
