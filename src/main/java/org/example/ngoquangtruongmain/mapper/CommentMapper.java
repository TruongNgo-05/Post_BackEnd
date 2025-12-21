package org.example.ngoquangtruongmain.mapper;

import org.example.ngoquangtruongmain.dto.CommentDto;
import org.example.ngoquangtruongmain.entity.Comment;
import org.example.ngoquangtruongmain.form.CommentCreateForm;
import org.example.ngoquangtruongmain.form.CommentUpdateFrom;

public class CommentMapper {
    public static CommentDto map(Comment comment) {
        var dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setContent(comment.getContent());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setUpdatedDate(comment.getUpdatedAt());
        return dto;
    }

    public static Comment map(CommentCreateForm form) {
        var comment = new Comment();
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setContent(form.getContent());
        return  comment;
    }

    public static void map(CommentUpdateFrom form, Comment comment) {
        comment.setName(form.getName());
        comment.setEmail(form.getEmail());
        comment.setContent(form.getContent());
    }
}
