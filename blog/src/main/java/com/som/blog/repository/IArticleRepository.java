package com.som.blog.repository;

import com.som.blog.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IArticleRepository extends JpaRepository<Article,Long> {

}
