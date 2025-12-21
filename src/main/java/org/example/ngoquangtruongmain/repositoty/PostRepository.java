package org.example.ngoquangtruongmain.repositoty;

import org.example.ngoquangtruongmain.dto.PostDto;
import org.example.ngoquangtruongmain.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Page<PostDto> findAllPost(Pageable pageable);
}
