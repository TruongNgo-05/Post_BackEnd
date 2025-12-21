package org.example.ngoquangtruongmain.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.ngoquangtruongmain.dto.CommentDto;
import org.example.ngoquangtruongmain.form.CommentCreateForm;
import org.example.ngoquangtruongmain.form.CommentUpdateFrom;
import org.example.ngoquangtruongmain.mapper.CommentMapper;
import org.example.ngoquangtruongmain.repositoty.CommentRepository;

import org.example.ngoquangtruongmain.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    final private CommentRepository commentRepository;

    @Override
    public List<CommentDto> findAllComment() {
        return commentRepository.findAll()
                .stream()
                .map(CommentMapper ::map)
                .toList();
    }

    @Override
    public CommentDto findById(Integer id) {
        return commentRepository.findById(id)
                .map(CommentMapper::map)
                .orElse(null);
    }

    @Override
    public CommentDto create(CommentCreateForm form) {
        var Comment = CommentMapper.map(form);
        var savedComment = commentRepository.save(Comment);
        return  CommentMapper.map(savedComment);
    }

    @Override
    public CommentDto update(CommentUpdateFrom form, Integer id) {
        var optinalComment= commentRepository.findById(id);
        if(optinalComment.isEmpty()) {
            return null;
        }
        var Comment = optinalComment.get();
        CommentMapper.map(form,Comment);
        var savedComment = commentRepository.save(Comment);
        return  CommentMapper.map(savedComment);
    }

    @Override
    public void delete(Integer id) {
        commentRepository.deleteById(id);
    }
}
