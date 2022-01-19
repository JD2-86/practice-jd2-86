package by.paramonov.hibernate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "louvre")
public class Painting {
    @Id
    @Getter
    @Setter
    @Column(name = "picture_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "picture_name")
    private String name;

    @Column(name = "writer")
    private String authorName;
}
