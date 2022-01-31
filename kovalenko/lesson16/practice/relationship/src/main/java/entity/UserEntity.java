package entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Table(name = "user")
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
}
