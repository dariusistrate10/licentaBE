package com.example.demo.dto;
import com.example.demo.model.User;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
    User userPostDtoToUser(UserPostDto userPostDto);
    List<UserDto> usersToUserDto(List<User> users);
    User updateUserFromUserDto(UserDto userDto);
}
