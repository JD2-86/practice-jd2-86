package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "users")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
public class UserEntity extends BaseEntity{
    @Getter
    @Setter
    @Column(name = "name")
    private String name;
    @Getter
    @Setter
    @Column(name = "password")
    private String password;
    @Getter
    @Setter
    @Column(name = "email")
    private String email;
    @Getter
    @Setter
    @Column(name = "first_name")
    private String firstname;
    @Getter
    @Setter
    @Column(name = "last_name")
    private String lastname;
    @Getter
    @Setter
    @Column(name = "age")
    private Integer age;
    @Getter
    @Setter
    @Column(name = "birthday")
    private LocalDate birthday;
    @OneToOne
    @JoinColumn(name = "role_id")
    private RoleEntity role;
}
