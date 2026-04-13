package com.example.blogapp.sevice.Impl;

import com.example.blogapp.dto.Respone.UserDto;
import com.example.blogapp.dto.request.UserCreateForm;
import com.example.blogapp.dto.request.UserUpdateForm;
import com.example.blogapp.entity.User;
import com.example.blogapp.exception.ApplicationException;
import com.example.blogapp.mapper.UserMapper;
import com.example.blogapp.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserSeviceImpl {
    private final UserRepository userRepository;

    public List<UserDto> getUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            UserDto userDto = UserMapper.map(user);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    public UserDto getUserById(Long id) {
       Optional<User> optionalUser = userRepository.findById(id);
       if (optionalUser.isEmpty()){
           throw new ApplicationException("User not found");
       }
       User user = optionalUser.get();
       UserDto userDto = UserMapper.map(user);
       return userDto;
    }

    public UserDto createUser(UserCreateForm  userCreateForm) {
        User user = userRepository.findByEmail(userCreateForm.getEmail());
        if (user != null){
            throw new ApplicationException("Email User already exists");
        }
        User users= UserMapper.map(userCreateForm);
        User saveUser= userRepository.save(users);
        UserDto userDto = UserMapper.map(saveUser);
        return  userDto;
    }

    public UserDto updateUser(UserUpdateForm userUpdateForm, Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()){
            throw new ApplicationException("User not found");
        }
        User user = optionalUser.get();
        UserMapper.map(userUpdateForm,user);
        UserDto userDto = UserMapper.map(user);
        return userDto;
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
