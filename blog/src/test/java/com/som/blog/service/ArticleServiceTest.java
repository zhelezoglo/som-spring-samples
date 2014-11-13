package com.som.blog.service;

import com.som.blog.domain.Article;
import com.som.blog.domain.User;
import com.som.blog.domain.base.UserRole;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * @author som
 */
public class ArticleServiceTest extends AbstractGenericServiceTest<Article> {

    @Override
    protected IArticleService getService() {
        return appContext.getBean(IArticleService.class);
    }

    public ArticleServiceTest() {
        System.out.println("Article Service Started");
    }

    @Override
    protected Article getFirstEntity() {
        User author = new User("login1", "pass", "email", UserRole.AUTHOR);
        author.setId(1L);
        return new Article("Topic1", "Body1", author);
    }

    @Override
    protected Article getSecondEntity() {
        User author2 = new User("login2", "pass", "email2", UserRole.AUTHOR);
        author2.setId(2L);
        return new Article("Topic2", "Body2", author2);

    }

    @Test
    public void testGetArticleByAuthor() throws Exception {
        User author = new User("user1", "qwerty", "my_email", UserRole.AUTHOR);
        author.setId(3L);

        Article a1 = getFirstEntity();
        Article a2 = getSecondEntity();
        Article a3 = new Article("Topic", "Body", author);
        Article a4 = new Article("Topic1", "Body1", author);

        getService().save(a3);
        getService().save(a4);

        List<Article> foundArticles = getService().getArticles(author);

        assertNotSame(a1.getAuthor(), foundArticles.get(0).getAuthor());
        assertNotSame(a2.getAuthor(), foundArticles.get(1).getAuthor());
        assertEquals(a3.getAuthor(), foundArticles.get(0).getAuthor());
        assertEquals(a4.getAuthor(), foundArticles.get(1).getAuthor());

        assertEquals("Should only 2 articles be returned", foundArticles.size(), 2);

    }

    @Test
    public void testGetArticleByAuthorID() {
        Long id = getFirstEntity().getAuthor().getId();
        User author = new User("login1", "pass", "email", UserRole.AUTHOR);
        author.setId(id);

        Article a1 = new Article("Topic", "Body", author);
        Article a2 = getFirstEntity();
        Article a3 = getSecondEntity();

        getService().save(a1);

        List<Article> foundArticles = getService().getArticles(id);

        assertEquals(a1.getAuthor().getId(), foundArticles.get(0).getAuthor().getId());
        assertEquals(a2.getAuthor().getId(), foundArticles.get(1).getAuthor().getId());
        assertNotSame(a3.getAuthor().getId(), foundArticles.get(0).getAuthor().getId());

        assertEquals("Should only 2 articles be returned", foundArticles.size(), 2);

    }
}
