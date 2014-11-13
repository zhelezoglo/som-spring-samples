package com.som.blog.service.impl.real_ts;

import com.som.blog.domain.Article;
import com.som.blog.domain.User;
import com.som.blog.service.IArticleService;

import java.util.List;

/**
 * @author som
 */
public class ArticleService extends AbstractGenericServiceImpl<Article> implements IArticleService {
    @Override
    public List<Article> getArticles(User author) {
        return null;  // TODO: Implement
    }

    @Override
    public List<Article> getArticles(Long authorId) {
        return null;  // TODO: Implement
    }
}
