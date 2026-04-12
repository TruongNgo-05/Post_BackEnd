package com.example.blogapp.sevice;

import com.example.blogapp.dto.PostDto;
import com.example.blogapp.form.PostCreateForm;
import com.example.blogapp.form.PostUpdateForm;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto findById(Long id);

    PostDto create(PostCreateForm postCreateForm);

    PostDto update(PostUpdateForm postUpdateForm, Long id);

    void deleteById(Long id);
}
