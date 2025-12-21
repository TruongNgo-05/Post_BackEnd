package org.example.ngoquangtruongmain.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@JsonPropertyOrder({"id","name","email","content","createAt","updateAt"})
public class CommentDto {

    private Integer id;

    private String name;

    private String email;

    private String content;

    private LocalDateTime createdAt;

    private LocalDateTime updatedDate;
}
