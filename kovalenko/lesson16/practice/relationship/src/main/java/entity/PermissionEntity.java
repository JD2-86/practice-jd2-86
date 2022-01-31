package entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "permission")
@AttributeOverride(name = "id", column = @Column(name = "permission_id"))
public class PermissionEntity extends BaseEntity{
    @Getter
    @Setter
    @Column(name = "code")
    private String code;
    @Getter
    @Setter
    @Column(name = "description")
    private String description;

    @ManyToOne()
    @JoinColumn(name = "code")
    private OperationEntity operation;

    @ManyToOne
    @JoinColumn(name = "object_id")
    private ObjectEntity object;
}
