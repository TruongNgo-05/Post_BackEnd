package com.example.blogapp.mapper;

import com.example.blogapp.constant.Role;
import com.example.blogapp.dto.Respone.UserDto;
import com.example.blogapp.dto.request.UserCreateForm;
import com.example.blogapp.dto.request.UserUpdateForm;
import com.example.blogapp.entity.User;
import org.springframework.beans.BeanUtils;

public class UserMapper {

public static UserDto map(User user) {
    UserDto dto = new UserDto();
//    dto.setId(user.getId());
//    dto.setFullName(user.getFullName());
//    dto.setUserName(user.getUserName());
//    dto.setEmail(user.getEmail());
//    dto.setRole(user.getRole());
//    dto.setCreatedAt(user.getCreatedAt());
//    dto.setUpdatedAt(user.getUpdatedAt());
    BeanUtils.copyProperties(user, dto);
    return dto;
}

public static User map(UserCreateForm userCreateForm) {
    User user = new User();
//    user.setFullName(userCreateForm.getFullName());
//    user.setUserName(userCreateForm.getUserName());
//    user.setEmail(userCreateForm.getEmail());
//    user.setPassWord(userCreateForm.getPassWord());
//    user.setRole(Role.CUSTOMER);
    BeanUtils.copyProperties(userCreateForm, user);
    user.setRole(Role.CUSTOMER);
    return user;
}

public static void map(UserUpdateForm userUpdateForm, User user) {
    if (userUpdateForm.getFullName() != null) {
        user.setFullName(userUpdateForm.getFullName());
    }
    if (userUpdateForm.getEmail() != null) {
        user.setEmail(userUpdateForm.getEmail());
    }
    if (userUpdateForm.getPassWord() != null) {
        user.setPassWord(userUpdateForm.getPassWord());
    }
}
}
