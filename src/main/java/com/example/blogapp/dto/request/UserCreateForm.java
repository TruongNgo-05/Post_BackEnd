package com.example.blogapp.dto.request;

import com.example.blogapp.constant.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {

    private String fullName;

    private String userName;

    private String email;

    private String passWord;

    private Role role;

}
