package com.som.blog.service.impl.fake;

import com.som.blog.domain.Article;
import com.som.blog.domain.Comment;
import com.som.blog.service.ICommentService;
import com.som.blog.service.exceptions.GeneralServiceException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author som
 */
public class CommentService extends AbstractGenericService<Comment> implements ICommentService {

    protected static Map<Long, Comment> storage = new HashMap<Long, Comment>();

    @Override
    protected Map<Long, Comment> storage() {
        return storage;
    }

    @Override
    public List<Comment> getTopLevelCommentsOfArticle(Article article) throws IllegalArgumentException, GeneralServiceException {
        checkThrowEntityNull(article);
        return getTopLevelCommentsOfArticle(article.getId());
    }

    @Override
    public List<Comment> getTopLevelCommentsOfArticle(Long articleId) throws IllegalArgumentException, GeneralServiceException {
        checkThrowIdNull(articleId);
        List<Comment> result = new ArrayList<Comment>();
        for (Comment comment : getAllEntities()) {
            if (comment.getParentId().equals(articleId)) {
                result.add(comment);
            }
        }
        return result;
    }

    @Override
    public List<Comment> getTopLevelCommentsOfComment(Comment comment) throws IllegalArgumentException, GeneralServiceException {
        checkThrowEntityNull(comment);
        return getTopLevelCommentsOfComment(comment.getId());
    }

    @Override
    public List<Comment> getTopLevelCommentsOfComment(Long commentId) throws IllegalArgumentException, GeneralServiceException {
        checkThrowIdNull(commentId);
        List<Comment> result = new ArrayList<Comment>();
        for (Comment comment : getAllEntities()) {
            if (comment.getParentId().equals(commentId)) {
                result.add(comment);
            }
        }
        return result;
    }
}
