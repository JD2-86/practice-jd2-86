package by.zhigalko.mapper.mapper;

import by.zhigalko.mapper.dto.UserDto;
import by.zhigalko.mapper.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "account", target = "username")
    @Mapping(source = "role", target = "role")
    @Mapping(source = "fullName", target = "name")
    User userDtoToUser(UserDto userDto);

    @Mapping(source = "userId", target = "id")
    @Mapping(source = "username", target = "account")
    @Mapping(source = "role", target = "role")
    @Mapping(source = "name", target = "fullName")
    UserDto userToUserDto(User user);
}
