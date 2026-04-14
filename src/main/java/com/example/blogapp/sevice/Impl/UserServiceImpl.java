package com.example.blogapp.sevice.Impl;

import com.example.blogapp.dto.Respone.UserDto;
import com.example.blogapp.dto.request.UserCreateForm;
import com.example.blogapp.dto.request.UserUpdateForm;
import com.example.blogapp.entity.User;
import com.example.blogapp.exception.ApplicationException;
import com.example.blogapp.mapper.UserMapper;
import com.example.blogapp.repository.UserRepository;
import com.example.blogapp.sevice.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public Page<UserDto> getUsers(Pageable pageable) {
//        List<User> users = userRepository.findAll();
//        List<UserDto> userDtos = new ArrayList<>();
//        for (User user : users) {
//            userDtos.add(UserMapper.map(user));
//        }
//        return userDtos;
        Page<User> users = userRepository.findAll(pageable);
        return users.map(UserMapper::map);
    }

    @Override
    public UserDto getUserById(Long id) {
       Optional<User> optionalUser = userRepository.findById(id);
       if (optionalUser.isEmpty()){
           throw new ApplicationException("User not found");
       }
       User user = optionalUser.get();
       UserDto userDto = UserMapper.map(user);
       return userDto;
    }

    @Transactional
    @Override
    public UserDto createUser(UserCreateForm userCreateForm) {
        Optional<User> user = userRepository.findByEmail(userCreateForm.getEmail());
        if (user.isPresent()) {
            throw new ApplicationException("Email already exists");
        }
        User users= UserMapper.map(userCreateForm);
        User saveUser= userRepository.save(users);
        UserDto userDto = UserMapper.map(saveUser);
        return  userDto;
    }

    @Transactional
    @Override
    public UserDto updateUser(UserUpdateForm userUpdateForm, Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()){
            throw new ApplicationException("User not found");
        }
        User user = optionalUser.get();
        UserMapper.map(userUpdateForm,user);
        UserDto userDto = UserMapper.map(userRepository.save(user));
        return userDto;
    }

    @Transactional
    @Override
    public String deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()){
            throw new ApplicationException("User not found");
        }
        userRepository.deleteById(id);
        return "Delete success";
    }
}
