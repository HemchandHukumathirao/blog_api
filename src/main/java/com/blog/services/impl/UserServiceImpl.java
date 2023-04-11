package com.blog.services.impl;

import com.blog.entities.User;
import com.blog.exceptions.ResourceNotFoundException;
import com.blog.payloads.UserDto;
import com.blog.repositories.UserRepository;
import com.blog.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
            
    @Override
    public UserDto createUser(UserDto userDto) {
        User userToCreate = this.modelMapper.map(userDto, User.class);
        return this.modelMapper.map(this.userRepository.save(userToCreate), UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        
        User updatedUser = this.userRepository.save(user);
        return this.modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> allUsers = this.userRepository.findAll();
        List<UserDto> allUsersDto = allUsers.stream().map(user -> modelMapper.map(user,  UserDto.class)).toList();
        return allUsersDto;
    }

    @Override
    public void deleteUser(Integer userId) {
        this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        this.userRepository.deleteById(userId);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        return this.modelMapper.map(this.userRepository.save(user), UserDto.class);
    }
}
