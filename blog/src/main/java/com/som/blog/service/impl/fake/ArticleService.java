package com.som.blog.service.impl.fake;

import com.som.blog.domain.Article;
import com.som.blog.domain.User;
import com.som.blog.service.IArticleService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author me
 */
public class ArticleService extends AbstractGenericService<Article> implements IArticleService {

    protected static Map<Long, Article> storage = new HashMap<Long, Article>();


    public ArticleService() {
    }

    @Override
    protected Map<Long, Article> storage() {
        return storage;
    }

    @Override
    public List<Article> getArticles(User author) {
        checkThrowEntityNull(author);
        return getArticles(author.getId());
    }

    @Override
    public List<Article> getArticles(Long authorId) {
        checkThrowIdNull(authorId);
        List<Article> result = new ArrayList<Article>();
        for (Article article : getAllEntities()) {
            if (article.getAuthor().getId().equals(authorId)) {
                result.add(article);
            }
        }
        return result;
    }
}
