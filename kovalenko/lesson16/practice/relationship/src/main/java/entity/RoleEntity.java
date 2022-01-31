package entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "role")
@AttributeOverride(name = "id", column = @Column(name = "role_id"))
public class RoleEntity extends BaseEntity{
    @Getter
    @Setter
    @Column(name = "code")
    private String code;
    @Getter
    @Setter
    @Column(name = "description")
    private String description;
}
