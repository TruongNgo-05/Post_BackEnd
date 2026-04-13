package com.example.blogapp.mapper;

import com.example.blogapp.dto.CommentDto;
import com.example.blogapp.entity.Comment;
import com.example.blogapp.form.CommentCreateForm;
import com.example.blogapp.form.CommentUpdateForm;

public class CommentMapper {
 public static CommentDto map(Comment comment) {
     CommentDto commentDto = new CommentDto();
     commentDto.setId(comment.getId());
     commentDto.setName(comment.getName());
     commentDto.setContent(comment.getContent());
     commentDto.setEmail(comment.getEmail());
     commentDto.setCreatedAt(comment.getCreatedAt());
     commentDto.setUpdatedAt(comment.getUpdatedAt());
     return commentDto;
 }

 public static Comment map (CommentCreateForm commentCreateForm) {
     Comment comment = new Comment();
     comment.setName(commentCreateForm.getName());
     comment.setEmail(commentCreateForm.getEmail());
     comment.setContent(commentCreateForm.getContent());
    return   comment;
 }

 public static void map (CommentUpdateForm commentUpdateForm, Comment comment) {
    comment.setName(commentUpdateForm.getName());
    comment.setEmail(commentUpdateForm.getEmail());
    comment.setContent(commentUpdateForm.getContent());
 }
}
