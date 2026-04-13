package com.example.blogapp.entity;

import com.example.blogapp.constant.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="fullname" , length=50, nullable=false)
    private String fullName;

    @Column(name="username" , length=100, nullable=false)
    private String userName;

    @Column(name="email" , length=50, nullable=false)
    private String email;

    @Column(name="password" , length=100, nullable=false)
    private String passWord;

    @Column(name="role")
    private Role role;

    @CreationTimestamp
    @Column(name="created_at")
    LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    LocalDateTime updatedAt;
}
