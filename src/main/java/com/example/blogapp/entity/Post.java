package com.example.blogapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto increment
    private Long id;

    @Column(name="title" , length = 50 , nullable = false)
    private String title;

    @Column(name="description" , length = 100 , nullable = false)
    private String description;

    @Column(name="content" , length = 150 , nullable = false)
    private String content;

    @Column(name="created_at" , nullable = false , updatable = false)
    @CreationTimestamp // lấy thời gian tạo thành thời gian hiện tại
    private LocalDateTime createdAt;

    @Column(name="updated_at" , nullable = false)
    @UpdateTimestamp // lấy thời gian cập nhật thành thời gian hiện tại
    private LocalDateTime updatedAt;
}
