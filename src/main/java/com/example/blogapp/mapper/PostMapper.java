package com.example.blogapp.mapper;

import com.example.blogapp.dto.Respone.PostDto;
import com.example.blogapp.entity.Post;
import com.example.blogapp.dto.request.PostCreateForm;
import com.example.blogapp.dto.request.PostUpdateForm;
import org.springframework.beans.BeanUtils;

public class PostMapper {
    public static PostDto map(Post post) {
        PostDto postDto = new PostDto();
        BeanUtils.copyProperties(post,postDto);
        return postDto;
    }

    public static Post map(PostCreateForm createForm) {
        Post post = new Post();
        BeanUtils.copyProperties(createForm,post);
        return post;
    }

// ánh xạ từ font cập nhật vào dữ liệu trong database
public static void map(PostUpdateForm form, Post post) {

    if (form.getTitle() != null) {
        post.setTitle(form.getTitle());
    }

    if (form.getDescription() != null) {
        post.setDescription(form.getDescription());
    }

    if (form.getContent() != null) {
        post.setContent(form.getContent());
    }
}
}
