package com.example.blogapp.mapper;

import com.example.blogapp.dto.Respone.CommentDto;
import com.example.blogapp.entity.Comment;
import com.example.blogapp.dto.request.CommentCreateForm;
import com.example.blogapp.dto.request.CommentUpdateForm;
import org.springframework.beans.BeanUtils;


public class CommentMapper {
 public static CommentDto map(Comment comment) {
     CommentDto commentDto = new CommentDto();
     BeanUtils.copyProperties(comment,commentDto);
     return commentDto;
 }

 public static Comment map (CommentCreateForm commentCreateForm) {
     Comment comment = new Comment();
     BeanUtils.copyProperties(commentCreateForm,comment);
    return   comment;
 }

 public static void map (CommentUpdateForm commentUpdateForm, Comment comment) {
     if (commentUpdateForm.getName() != null) {
         comment.setName(commentUpdateForm.getName());
     }
     if (commentUpdateForm.getEmail() != null) {
         comment.setEmail(commentUpdateForm.getEmail());
     }
     if (commentUpdateForm.getContent() != null) {
         comment.setContent(commentUpdateForm.getContent());
     }
 }

}
