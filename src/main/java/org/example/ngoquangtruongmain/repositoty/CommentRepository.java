package org.example.ngoquangtruongmain.repositoty;

import org.example.ngoquangtruongmain.dto.CommentDto;
import org.example.ngoquangtruongmain.entity.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
