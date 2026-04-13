package com.example.blogapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostUpdateForm {

    private String title;

    private String description;

    private String content;

}
