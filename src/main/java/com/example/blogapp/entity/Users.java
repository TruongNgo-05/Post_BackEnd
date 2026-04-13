package com.example.blogapp.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name="users")
public class Users {
//    id INT AUTO_INCREMENT PRIMARY KEY,
//    name VARCHAR(50) NOT NULL,
//    username VARCHAR(100) NOT NULL,
//    email VARCHAR(50) NOT NULL UNIQUE,
//    password VARCHAR(100) NOT NULL,
//    role varchar(50),
//    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
//    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
//    ON UPDATE CURRENT_TIMESTAMP

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


}
