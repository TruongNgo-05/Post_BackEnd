package com.example.blogapp.sevice.Impl;

import com.example.blogapp.dto.Respone.CommentDto;
import com.example.blogapp.dto.request.CommentCreateForm;
import com.example.blogapp.dto.request.CommentUpdateForm;
import com.example.blogapp.entity.Comment;
import com.example.blogapp.exception.ApplicationException;
import com.example.blogapp.mapper.CommentMapper;
import com.example.blogapp.repository.CommentRepository;
import com.example.blogapp.sevice.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;


    @Override
    public List<CommentDto> findAll(){
    List<Comment> comments = commentRepository.findAll();
    List<CommentDto> dtos = new ArrayList<>();
    for (Comment comment : comments) {
        CommentDto dto = CommentMapper.map(comment);
        dtos.add(dto);
    }
    return dtos;
    }

    @Override
    public CommentDto findById(Long id){
        Optional<Comment> optional = commentRepository.findById(id);
        if (optional.isEmpty()) {
             throw new ApplicationException(" id k tìm thấy ");
        }
        Comment comment = optional.get();
        CommentDto dto = CommentMapper.map(comment);
        return dto;
    }

    @Transactional
    @Override
    public CommentDto create(CommentCreateForm commentCreateForm){
        Comment comment = commentRepository.findByEmail(commentCreateForm.getEmail());
        if (comment != null) {
            throw new ApplicationException("email da co");
        }
        Comment savedComment = commentRepository.save(CommentMapper.map(commentCreateForm));
        CommentDto dto = CommentMapper.map( savedComment);
        return dto ;
    }

    @Transactional
    @Override
    public CommentDto update(Long id, CommentUpdateForm commentUpdateForm){
        Optional<Comment> optional = commentRepository.findById(id);
        if (optional.isEmpty()) {
            throw new ApplicationException("k tim thay id");
        }
        Comment comment = optional.get();
        CommentMapper.map(commentUpdateForm,comment);
        CommentDto dto = CommentMapper.map(comment);
        return dto;
    }

    @Transactional
    @Override
    public void deleteById(Long id){
        commentRepository.deleteById(id);
    }
}
