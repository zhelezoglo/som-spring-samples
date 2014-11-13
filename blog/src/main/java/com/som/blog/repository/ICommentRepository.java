package com.som.blog.repository;

import com.som.blog.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment,Long> {



}
