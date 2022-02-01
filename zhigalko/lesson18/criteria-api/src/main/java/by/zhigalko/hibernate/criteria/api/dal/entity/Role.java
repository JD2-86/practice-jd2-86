package by.zhigalko.hibernate.criteria.api.dal.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "users", callSuper = false)
@ToString(exclude = "users")
@Table(name = "role")
@AttributeOverride(name = "id", column = @Column(name = "role_id"))
public class Role extends BaseEntity{

    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @OneToMany(mappedBy = "role")
    private Set<User> users = new HashSet<>();

    public void addUser(User user) {
        this.users.add(user);
        user.setRole(this);
    }
}
