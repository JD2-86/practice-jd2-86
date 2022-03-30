package by.zhigalko.mapper.dto;

import lombok.*;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
    private UUID id;
    private String account;
    private String role;
    private String fullName;
}
