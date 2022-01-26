package by.zhigalko.hibernate.mapping.relationship.dal.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "role", callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "\"user\"")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
public class User extends BaseEntity{
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthday")
    private LocalDate birthday;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;
}
