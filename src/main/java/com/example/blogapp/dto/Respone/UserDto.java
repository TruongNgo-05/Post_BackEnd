package com.example.blogapp.dto.Respone;

import com.example.blogapp.constant.Role;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@JsonPropertyOrder({"id","fullName","userName","email","role","createdAt","updatedAt"})
public class UserDto {

    private Long id;

    private String fullName;

    private String userName;

    private String email;

    private Role role;

    LocalDateTime createdAt;

    LocalDateTime updatedAt;
}
