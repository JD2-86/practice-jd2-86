package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "object")
@AttributeOverride(name = "id", column = @Column(name = "object_id"))
public class ObjectEntity extends BaseEntity{
    @Getter
    @Setter
    @Column(name = "code")
    private String code;
    @Getter
    @Setter
    @Column(name = "description")
    private String description;

    @ManyToOne
    private PermissionEntity permission;
}
