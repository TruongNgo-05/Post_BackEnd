package com.example.blogapp.sevice;

import com.example.blogapp.dto.Respone.PostDto;
import com.example.blogapp.dto.request.PostCreateForm;
import com.example.blogapp.dto.request.PostUpdateForm;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto findById(Long id);

    PostDto create(PostCreateForm postCreateForm);

    PostDto update(PostUpdateForm postUpdateForm, Long id);

    void deleteById(Long id);
}
