package org.example.ngoquangtruongmain.controller;

import lombok.RequiredArgsConstructor;
import org.example.ngoquangtruongmain.dto.CommentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CommentController {
//
//    final CommentService commentService;

    @GetMapping
    public List<CommentDto> findAllComment() {
//        return commentService.findAllComment();
    }
}
