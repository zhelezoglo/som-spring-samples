package com.som.blog.service;

import com.som.blog.domain.Article;
import com.som.blog.domain.User;

import java.util.List;

/**
 * @author som
 */
public interface IArticleService extends IGenericService<Article> {

    public List<Article> getArticles(User author);

    public List<Article> getArticles(Long authorId);

}
