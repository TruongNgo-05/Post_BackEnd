package com.example.blogapp.sevice;

import com.example.blogapp.dto.Respone.UserDto;
import com.example.blogapp.dto.request.UserCreateForm;
import com.example.blogapp.dto.request.UserUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    Page<UserDto> getUsers(Pageable pageable);

    UserDto getUserById(Long id);

    UserDto createUser(UserCreateForm userCreateForm);

    UserDto updateUser(UserUpdateForm userUpdateForm, Long id);

    String deleteUser(Long id);
}
