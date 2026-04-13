package com.example.blogapp.controller;

import com.example.blogapp.dto.Respone.CommentDto;
import com.example.blogapp.dto.request.CommentCreateForm;
import com.example.blogapp.dto.request.CommentUpdateForm;
import com.example.blogapp.sevice.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/comments")
public class CommentController {
    private final CommentService commentService;

    @GetMapping
    public List<CommentDto> findAll(){
        return commentService.findAll();
    }

    @GetMapping("/{id}")
    public CommentDto findById(@PathVariable Long id){
        return commentService.findById(id);
    }

    @PostMapping
    public CommentDto create(@RequestBody CommentCreateForm commentCreateForm){
        return commentService.create(commentCreateForm);
    }

    @PutMapping("{id}")
    public CommentDto update(@PathVariable Long id, @RequestBody CommentUpdateForm commentUpdateForm){
        return commentService.update(id, commentUpdateForm);
    }

    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Long id){
        commentService.deleteById(id);
    }
}
