package com.example.blogapp.sevice.Impl;

import com.example.blogapp.dto.PostDto;
import com.example.blogapp.entity.Post;
import com.example.blogapp.form.PostCreateForm;
import com.example.blogapp.form.PostUpdateForm;
import com.example.blogapp.mapper.PostMapper;
import com.example.blogapp.repository.PostRepository;
import com.example.blogapp.sevice.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;


    @Override
    public List<PostDto> findAll() {
//       var posts = postRepository.findAll();
//
//       var dtos = new ArrayList<PostDto>();
//       for(Post post : posts) {
//           var dto = PostMapper.map(post);
//           dtos.add(dto);
//       }
//       return dtos;


//        return postRepository.findAll()
//                .stream().map(new  Function<Post, PostDto>() {
//                    @Override
//                    public PostDto apply(Post post) {
//                        return PostMapper.map(post);
//                    }
//                }).toList();

        return postRepository.findAll()
                .stream()
                .map(PostMapper::map)
                .toList();
    }

    @Override
    public PostDto findById(Long id) {
        return postRepository.findById(id)
                .map(PostMapper::map)
                .orElseThrow(null);
    }

    @Override
    public PostDto create(PostCreateForm postCreateForm) {
        var post =PostMapper.map(postCreateForm);
        var newPost = postRepository.save(post);
        return PostMapper.map(newPost);
    }

    @Override
    public PostDto update(PostUpdateForm postUpdateForm, Long id) {
        var optional = postRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }
        var post = optional.get();
        PostMapper.map(postUpdateForm, post);
        var savedPost = postRepository.save(post);
return PostMapper.map(savedPost);
    }

    @Override
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
