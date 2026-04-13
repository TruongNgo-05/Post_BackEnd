package com.example.blogapp.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentUpdateForm {

    private String name;

    private String email;

    private String content;

}
