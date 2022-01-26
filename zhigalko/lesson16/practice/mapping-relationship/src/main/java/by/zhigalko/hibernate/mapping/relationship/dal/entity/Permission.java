package by.zhigalko.hibernate.mapping.relationship.dal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import lombok.*;
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString(exclude = "roles")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"operation", "object"},callSuper = false)
@Table(name = "permission")
@AttributeOverride(name = "id", column = @Column(name = "permission_id"))
public class Permission extends BaseEntity {
    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "operation_id", nullable = false)
    private Operation operation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "object_id", nullable = false)
    private ObjectEntity object;

    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<>();
}
