package by.zhigalko.mapper.entity;

import by.zhigalko.mapper.model.Role;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    private UUID userId;
    private String username;
    private Role role;
    private String name;
}
