package org.example.ngoquangtruongmain.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@JsonPropertyOrder({"id","titlr","description","content","createAt","updateAt"})
public class PostDto {
    private int id;
    private String title;
    private String description;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
