package com.blog.services;

import com.blog.payloads.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto userDto);
    public UserDto updateUser(UserDto userDto, Integer userId);
    public List<UserDto> getAllUsers();
    public void deleteUser(Integer userId);
    public UserDto getUserById(Integer userId);
}
