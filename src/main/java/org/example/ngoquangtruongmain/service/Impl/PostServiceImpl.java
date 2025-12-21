package org.example.ngoquangtruongmain.service.Impl;

import lombok.RequiredArgsConstructor;
import org.example.ngoquangtruongmain.dto.PostDto;
import org.example.ngoquangtruongmain.form.PostCreateForm;
import org.example.ngoquangtruongmain.form.PostUpdateForm;
import org.example.ngoquangtruongmain.mapper.PostMapper;
import org.example.ngoquangtruongmain.repositoty.PostRepository;
import org.example.ngoquangtruongmain.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.example.ngoquangtruongmain.mapper.PostMapper.map;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    final private PostRepository postRepository;

    @Override
    public List<PostDto> findAll() {

        return postRepository.findAll()
        .stream()
                .map( PostMapper::map)
                .toList();
    }

    @Override
    public PostDto findById(Integer id) {
        return postRepository.findById(id)
        .map(PostMapper::map)
                .orElse(null);
    }

    @Override
    public PostDto create(PostCreateForm form) {
        var post = PostMapper.map(form);
        var savePost = postRepository.save(post);
        return PostMapper.map(savePost);
    }

    @Override
    public PostDto update(PostUpdateForm form, Integer id) {
        var optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) {
            return null;
        }
        var post = optionalPost.get();
        PostMapper.map(form, post);
        var updatePost = postRepository.save(post);
        return PostMapper.map(updatePost);
    }

    @Override
    public void delete(Integer id) {
        postRepository.deleteById(id);
    }
}
