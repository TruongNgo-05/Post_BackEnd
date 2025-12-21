package org.example.ngoquangtruongmain.controller;

import lombok.RequiredArgsConstructor;
import org.example.ngoquangtruongmain.dto.PostDto;
import org.example.ngoquangtruongmain.entity.Post;
import org.example.ngoquangtruongmain.form.PostCreateForm;
import org.example.ngoquangtruongmain.form.PostUpdateForm;
import org.example.ngoquangtruongmain.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {

    final private PostService postService;


    @GetMapping()
    public List<PostDto> findAll() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostDto findById(@PathVariable("id") Integer id) {
        return postService.findById(id);
    }

    @PostMapping()
    public PostDto create(@RequestBody PostCreateForm  form) {
        return postService.create(form);
    }

    @PutMapping("/{id}")
    public PostDto update(@RequestBody PostUpdateForm form,@PathVariable Integer  id) {
        return postService.update(form, id);
    }

    @DeleteMapping("/{id}")
    public void deleteAll(@PathVariable Integer id) {
     postService.delete(id);
    }
}
