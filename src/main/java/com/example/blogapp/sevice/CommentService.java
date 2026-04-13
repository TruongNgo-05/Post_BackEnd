package com.example.blogapp.sevice;

import com.example.blogapp.dto.CommentDto;
import com.example.blogapp.form.CommentCreateForm;
import com.example.blogapp.form.CommentUpdateForm;

import java.util.List;

public interface CommentService {
    List<CommentDto> findAll();

    CommentDto findById(Long id);

    CommentDto create(CommentCreateForm commentCreateForm);

    CommentDto update(Long id, CommentUpdateForm commentUpdateForm);

    void deleteById(Long id);
}
