package com.crud.backend.services;

import com.crud.backend.dtos.UserDto;
import com.crud.backend.exceptions.AppException;
import com.crud.backend.mappers.UserMapper;
import com.crud.backend.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.crud.backend.entities.User;
import com.crud.backend.dtos.UserDto;
import com.crud.backend.entities.User;
import org.mapstruct.Mapper;


import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

//    private final List<UserDto> users = Arrays.asList(
//            new UserDto(1, "James", "james@gmail.com", "9876567890"),
//            new UserDto(2, "John", "john@gmail.com", "9876543210")
//    );

    public List<UserDto> allUsers() {
        List<User> all = userRepository.findAll();
        return userMapper.toUserDtos(all);
    }

    public UserDto getUser(int id){

//        UserDto userDto = users.stream().filter(user -> id == user.getId())
//                .findFirst()
//                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
//        return userDto;
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

    public UserDto createUser(@Valid UserDto userDto) {
        User user = userMapper.toUser(userDto);
        User createdUser = userRepository.save(user);
        return userMapper.toUserDto(createdUser);
    }

    public UserDto deleteUser(int id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
        userRepository.deleteById(id);

        return userMapper.toUserDto(user);
    }

    public UserDto updateUser(int id, UserDto userDto){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
        userMapper.updateUser(user, userMapper.toUser(userDto));

        User updatedUser = userRepository.save(user);

        return userMapper.toUserDto(updatedUser);
    }
}
