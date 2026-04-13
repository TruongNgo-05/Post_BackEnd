package com.example.blogapp.controller;

import com.example.blogapp.dto.PostDto;
import com.example.blogapp.form.PostCreateForm;
import com.example.blogapp.form.PostUpdateForm;

import com.example.blogapp.sevice.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService postService;

    @GetMapping()
    public List<PostDto> findAll() {
        return postService.findAll();
    }

    @GetMapping("{id}")
    public PostDto findById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @PostMapping()
    public PostDto create(@RequestBody PostCreateForm postCreateForm) {
        return postService.create(postCreateForm);
    }

    @PutMapping({"{id}"})
    public PostDto update(@RequestBody PostUpdateForm postUpdateForm,@PathVariable Long id) {
        return postService.update(postUpdateForm, id);
    }

    @DeleteMapping({"{id}"})
    public void deleteById(@PathVariable Long id) {
        postService.deleteById(id);
    }
}

