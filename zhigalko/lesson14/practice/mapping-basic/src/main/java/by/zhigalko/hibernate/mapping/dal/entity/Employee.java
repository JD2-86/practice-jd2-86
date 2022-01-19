package by.zhigalko.hibernate.mapping.dal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Embedded;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.AttributeOverride;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "employee_catalog")
public class Employee extends BaseEntity {
    @Id
    @Column(name = "hero_id")
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "position")
    @Enumerated(EnumType.STRING)
    private Position position;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private LocalDate birthday;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "time_tracker_check")
    private ZonedDateTime timeTrackerCheck;

    @Temporal(TemporalType.TIME)
    @Column(name = "daily_meeting_beginning")
    private LocalTime dailyMeetingBeginning;

    @Column(name = "daily_meeting_duration")
    private Duration dailyMeetingDuration;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country",column = @Column(name = "home_address_country")),
            @AttributeOverride(name = "region",column = @Column(name = "home_address_region")),
            @AttributeOverride(name = "city",column = @Column(name = "home_address_city")),
            @AttributeOverride(name = "street",column = @Column(name = "home_address_street")),
            @AttributeOverride(name = "apartment",column = @Column(name = "home_address_apartment")),
    })
    private AddressSet homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "country",column = @Column(name = "work_address_country")),
            @AttributeOverride(name = "region",column = @Column(name = "work_address_region")),
            @AttributeOverride(name = "city",column = @Column(name = "work_address_city")),
            @AttributeOverride(name = "street",column = @Column(name = "work_address_street")),
            @AttributeOverride(name = "apartment",column = @Column(name = "work_address_apartment")),
    })
    private AddressSet workAddress;
}
