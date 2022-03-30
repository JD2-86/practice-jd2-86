package by.zhigalko.mapper.mapper;

import by.zhigalko.mapper.dto.UserDto;
import by.zhigalko.mapper.entity.User;
import by.zhigalko.mapper.model.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void userDtoToUserTest() {
        UserDto userDto = new UserDto();
        userDto.setId(UUID.fromString("9bb69019-e4de-4dae-8059-f09ae21d034b"));
        userDto.setAccount("test1username");
        userDto.setRole("USER");
        userDto.setFullName("ALEX");

        User user = userMapper.userDtoToUser(userDto);

        Assertions.assertNotNull(userDto);
        Assertions.assertEquals("ALEX", user.getName());
        Assertions.assertEquals(UUID.fromString("9bb69019-e4de-4dae-8059-f09ae21d034b"), user.getUserId());
        Assertions.assertEquals("test1username", user.getUsername());
        System.out.println(userDto);
        System.out.println(user);

    }

    @Test
    void userToUserDtoTest() {
        User user = new User();
        user.setUserId(UUID.fromString("9bb69019-e4de-4dae-8059-f09ae21d034b"));
        user.setUsername("test1username");
        user.setRole(Role.USER);
        user.setName("ALEX");

        UserDto userDto = userMapper.userToUserDto(user);

        Assertions.assertNotNull(userDto);
        Assertions.assertEquals("ALEX", userDto.getFullName());
        Assertions.assertEquals(UUID.fromString("9bb69019-e4de-4dae-8059-f09ae21d034b"), userDto.getId());
        Assertions.assertEquals("test1username", userDto.getAccount());
        System.out.println(user);
        System.out.println(userDto);
    }
}