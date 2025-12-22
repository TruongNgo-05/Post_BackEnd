package org.example.ngoquangtruongmain.service.Impl;

import org.example.ngoquangtruongmain.dto.PostDto;
import org.example.ngoquangtruongmain.form.PostCreateForm;
import org.example.ngoquangtruongmain.form.PostUpdateForm;
import org.example.ngoquangtruongmain.service.PostService;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostServiceV2Impl implements PostService {
    @Override
    public Page<PostDto> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public PostDto findById(Integer id) {
        return null;
    }

    @Override
    public PostDto create(PostCreateForm form) {
        return null;
    }

    @Override
    public PostDto update(PostUpdateForm form, Integer id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
