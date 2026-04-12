package com.example.blogapp.mapper;

import com.example.blogapp.dto.PostDto;
import com.example.blogapp.entity.Post;
import com.example.blogapp.form.PostCreateForm;
import com.example.blogapp.form.PostUpdateForm;

public class PostMapper {
    public static PostDto map(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        postDto.setCreatedAt(post.getCreatedAt());
        postDto.setUpdatedAt(post.getUpdatedAt());
        return postDto;
    }

    public static Post map(PostCreateForm createForm) {
        Post post = new Post();
        post.setTitle(createForm.getTitle());
        post.setDescription(createForm.getDescription());
        post.setContent(createForm.getContent());
        return post;
    }

// ánh xạ từ font cập nhật vào dữ liệu trong database
    public static void map(PostUpdateForm updateForm, Post post) {
        post.setTitle(updateForm.getTitle());
        post.setDescription(updateForm.getDescription());
        post.setContent(updateForm.getContent());
    }
}
