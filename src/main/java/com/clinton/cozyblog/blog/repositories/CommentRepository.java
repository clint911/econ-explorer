package com.clinton.cozyblog.blog.repositories;

import com.clinton.cozyblog.blog.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
