package com.crud.backend.mappers;

import com.crud.backend.dtos.UserDto;
import com.crud.backend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")

public interface UserMapper {
    User toUser(UserDto userDto);

    UserDto toUserDto(User user);

    List<UserDto> toUserDtos(List<User> users);

    void updateUser(@MappingTarget User target, User source);
}
