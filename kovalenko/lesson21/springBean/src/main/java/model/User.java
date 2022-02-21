package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
}
