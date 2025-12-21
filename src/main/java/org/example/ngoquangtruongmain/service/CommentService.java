package org.example.ngoquangtruongmain.service;

import org.example.ngoquangtruongmain.dto.CommentDto;
import org.example.ngoquangtruongmain.form.CommentCreateForm;
import org.example.ngoquangtruongmain.form.CommentUpdateFrom;

import java.util.List;

public interface CommentService {
    List<CommentDto> findAllComment();

    CommentDto findById(Integer id);

    CommentDto create(CommentCreateForm form);

    CommentDto update(Integer id,CommentUpdateFrom form);

    void delete(Integer id);
}
