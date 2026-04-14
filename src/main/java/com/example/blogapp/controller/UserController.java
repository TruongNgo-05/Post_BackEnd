package com.example.blogapp.controller;

import com.example.blogapp.Common.BaseResponse;
import com.example.blogapp.dto.Respone.UserDto;
import com.example.blogapp.dto.request.UserCreateForm;
import com.example.blogapp.dto.request.UserUpdateForm;
import com.example.blogapp.sevice.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<BaseResponse<Page<UserDto>>> getUsers(Pageable pageable) {
        return ResponseEntity.ok(new BaseResponse<>(
                userService.getUsers(pageable),
                "GetAll successfull" )) ;
    }

    @GetMapping("{id}")
    public ResponseEntity<BaseResponse<UserDto>> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(new BaseResponse<>(
                userService.getUserById(id),
                "GetID succses full"));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<UserDto>>createUser(@RequestBody UserCreateForm userCreateForm) {
        return ResponseEntity.ok(new BaseResponse<>(
                userService.createUser(userCreateForm),
                "create succses full"));
    }

    @PutMapping("{id}")
    public ResponseEntity<BaseResponse<UserDto>> updateUser(@RequestBody UserUpdateForm userUpdateForm,@PathVariable Long id) {
        return ResponseEntity.ok(new BaseResponse<>(
                userService.updateUser(userUpdateForm, id),
                "Update succses full"));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<BaseResponse<String>>  deleteUser(@PathVariable Long id) {
        userService.deleteUser(id)  ;
        return ResponseEntity.ok(new BaseResponse<>(
        null,"Delete succses full"));
    }

}
