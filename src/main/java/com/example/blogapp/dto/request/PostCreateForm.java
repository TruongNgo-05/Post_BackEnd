package com.example.blogapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCreateForm {

    private String title;

    private String description;

    private String content;

}
