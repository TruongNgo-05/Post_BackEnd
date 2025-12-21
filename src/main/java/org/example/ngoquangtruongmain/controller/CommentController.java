package org.example.ngoquangtruongmain.controller;

import lombok.RequiredArgsConstructor;
import org.example.ngoquangtruongmain.dto.CommentDto;
import org.example.ngoquangtruongmain.form.CommentCreateForm;
import org.example.ngoquangtruongmain.form.CommentUpdateFrom;
import org.example.ngoquangtruongmain.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {

    final CommentService commentService;

    @GetMapping
    public List<CommentDto> findAllComment() {
        return commentService.findAllComment();
    }

    @GetMapping
    public CommentDto findCommentById(@PathVariable("id") Integer id) {
        return commentService.findById(id);
    }

    @PostMapping()
    public CommentDto createComment(CommentCreateForm form) {
        return commentService.create(form);
    }

    @PutMapping("/{id}")
    public CommentDto updateCommentById(@PathVariable("id") Integer id, @RequestBody CommentUpdateFrom form) {
        return commentService.update(id,form);
    }
    @DeleteMapping("/{id}")
    public void deleteCommentById(@PathVariable("id") Integer id) {
        commentService.delete(id);
    }
}
