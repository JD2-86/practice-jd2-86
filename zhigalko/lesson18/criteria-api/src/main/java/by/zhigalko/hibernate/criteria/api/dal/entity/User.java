package by.zhigalko.hibernate.criteria.api.dal.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString
@Table(name = "\"user\"")
@AttributeOverride(name = "id", column = @Column(name = "user_id"))
@Builder
public class User extends BaseEntity {
    private String username;
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "user_weight")
    private Double userWeight;

    @Column(name = "user_height")
    private int userHeight;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id",nullable = false)
    private Role role;
}
