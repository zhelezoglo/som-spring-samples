package com.som.blog;

import com.som.blog.domain.Article;
import com.som.blog.repository.IArticleRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author som
 */
public class ArticleRepositoryTest {

    @Autowired
    IArticleRepository articleRepository;

    @Test
    public void testSaveArticle() throws Exception {
        articleRepository.save(new Article("topic", "body", null));

    }
}
