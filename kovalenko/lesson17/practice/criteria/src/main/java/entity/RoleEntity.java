package entity;

import jakarta.persistence.*;
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
