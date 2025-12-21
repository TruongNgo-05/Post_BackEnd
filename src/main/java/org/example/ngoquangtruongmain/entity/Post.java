package org.example.ngoquangtruongmain.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
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
@JsonPropertyOrder({"id","titlr","description","content","createAt","updateAt"})
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="title",length=50,nullable=false)
    private String title;

    @Column(name="description",length=100,nullable=false)
    private String description;

    @Column(name="content",length=150,nullable=false)
    private String content;

    @Column(name = "created_at",nullable=false,updatable=false  )
    @CreationTimestamp // tu lay tg hien tai
    private LocalDateTime createdAt;

    @Column(name = "updated_at",nullable=false)
    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
