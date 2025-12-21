package org.example.ngoquangtruongmain.service.Impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.example.ngoquangtruongmain.dto.PostDto;
import org.example.ngoquangtruongmain.entity.Post;
import org.example.ngoquangtruongmain.form.PostCreateForm;
import org.example.ngoquangtruongmain.form.PostUpdateForm;
import org.example.ngoquangtruongmain.mapper.CommentMapper;
import org.example.ngoquangtruongmain.mapper.PostMapper;
import org.example.ngoquangtruongmain.repositoty.PostRepository;
import org.example.ngoquangtruongmain.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.example.ngoquangtruongmain.mapper.PostMapper.map;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    final private PostRepository postRepository;
    final private ModelMapper modelMapper;

    @Override
    public Page<PostDto> findAll(Pageable pageable) {

        return postRepository.findAll(pageable)
                //lamda
                .map(post ->modelMapper.map(post, PostDto.class));
    }

    @Override
    public PostDto findById(Integer id) {
        return postRepository.findById(id)
                .map(post ->modelMapper.map(post, PostDto.class))
                .orElse(null);
    }

    @Override
    public PostDto create(PostCreateForm form) {
        var post = modelMapper.map(form, Post.class);
        var savePost = postRepository.save(post);
        return modelMapper.map(savePost,PostDto.class);
    }

    @Override
    public PostDto update(PostUpdateForm form, Integer id) {
        var optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            return null;
        }
        var post = optionalPost.get();
        modelMapper.map(form, post);
        var updatePost = postRepository.save(post);
        return modelMapper.map(updatePost,PostDto.class);
    }

    @Override
    public void delete(Integer id) {
        postRepository.deleteById(id);
    }
}
