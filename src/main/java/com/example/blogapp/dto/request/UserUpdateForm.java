package com.example.blogapp.dto.request;

import com.example.blogapp.constant.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateForm {

    private String fullName;

    private String email;

    private String passWord;

}
