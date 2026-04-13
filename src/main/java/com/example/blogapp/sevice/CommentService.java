package com.example.blogapp.sevice;

import com.example.blogapp.dto.Respone.CommentDto;
import com.example.blogapp.dto.request.CommentCreateForm;
import com.example.blogapp.dto.request.CommentUpdateForm;

import java.util.List;

public interface CommentService {
    List<CommentDto> findAll();

    CommentDto findById(Long id);

    CommentDto create(CommentCreateForm commentCreateForm);

    CommentDto update(Long id, CommentUpdateForm commentUpdateForm);

    void deleteById(Long id);
}
