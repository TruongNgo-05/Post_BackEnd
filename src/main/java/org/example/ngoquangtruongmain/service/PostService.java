package org.example.ngoquangtruongmain.service;

import org.example.ngoquangtruongmain.dto.PostDto;
import org.example.ngoquangtruongmain.form.PostCreateForm;
import org.example.ngoquangtruongmain.form.PostUpdateForm;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();

    PostDto findById(Integer id);

    PostDto create(PostCreateForm form);

    PostDto update(PostUpdateForm form, Integer id);

    void delete(Integer id);
}
