package org.example.ngoquangtruongmain.service;

import org.example.ngoquangtruongmain.dto.CommentDto;
import org.example.ngoquangtruongmain.form.CommentCreateForm;
import org.example.ngoquangtruongmain.form.CommentUpdateFrom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    Page<CommentDto> findAllComment(Pageable pageable);

    CommentDto findById(Integer id);

    CommentDto create(CommentCreateForm form);

    CommentDto update(Integer id,CommentUpdateFrom form);

    void delete(Integer id);
}
