package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Table(name = "operation")
@AttributeOverride(name = "id", column = @Column(name = "operation_id"))
public class OperationEntity extends BaseEntity{
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
