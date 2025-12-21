package org.example.ngoquangtruongmain.service;

import org.example.ngoquangtruongmain.dto.PostDto;
import org.example.ngoquangtruongmain.form.PostCreateForm;
import org.example.ngoquangtruongmain.form.PostUpdateForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostService {
    Page<PostDto> findAll(Pageable pageable);

    PostDto findById(Integer id);

    PostDto create(PostCreateForm form);

    PostDto update(PostUpdateForm form, Integer id);

    void delete(Integer id);
}
