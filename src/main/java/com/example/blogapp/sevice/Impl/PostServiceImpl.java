package com.example.blogapp.sevice.Impl;

import com.example.blogapp.dto.Respone.PostDto;
import com.example.blogapp.entity.Post;
import com.example.blogapp.exception.ApplicationException;
import com.example.blogapp.dto.request.PostCreateForm;
import com.example.blogapp.dto.request.PostUpdateForm;
import com.example.blogapp.mapper.PostMapper;
import com.example.blogapp.repository.PostRepository;
import com.example.blogapp.sevice.PostService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;


    @Override
    public List<PostDto> findAll() {
        List<Post> posts = postRepository.findAll();
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post : posts) {
            postDtos.add(PostMapper.map(post));
        }
        return postDtos;
    }

    @Override
    public PostDto findById(Long id) {
        Optional<Post> optional = postRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ApplicationException(" id not found ");
        }
        PostDto postDto = PostMapper.map(optional.get());
        return postDto;
    }

    @Transactional
    @Override
    public PostDto create(PostCreateForm postCreateForm) {
        Post post = PostMapper.map(postCreateForm);
        PostDto postDto = PostMapper.map(postRepository.save(post));
        return postDto;
    }

    @Transactional
    @Override
    public PostDto update(PostUpdateForm postUpdateForm, Long id) {
        Optional<Post> optional = postRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ApplicationException("id k ton tai");
        }
        Post post = optional.get();
        PostMapper.map(postUpdateForm, post);
        PostDto postDto = PostMapper.map(postRepository.save(post));
        return postDto;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
