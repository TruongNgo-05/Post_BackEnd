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
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "name" , length=50, nullable=false)
    private String name;

    @Column(name = "email" , length=100, nullable=false)
    private String email;

    @Column(name = "content" , length=200, nullable=false)
    private String content;

    @Column(name = "created_at" ,nullable=false,updatable=false)
    @CreationTimestamp
    LocalDateTime createdAt;

    @Column(name = "updated_at" ,nullable=false)
    @UpdateTimestamp
    LocalDateTime updatedAt;

}
