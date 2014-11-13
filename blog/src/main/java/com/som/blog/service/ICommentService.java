package com.som.blog.service;

import com.som.blog.domain.Article;
import com.som.blog.domain.Comment;
import com.som.blog.service.exceptions.GeneralServiceException;

import java.util.List;

/**
 * @author som
 */
public interface ICommentService extends IGenericService<Comment> {

    List<Comment> getTopLevelCommentsOfArticle(Article article) throws IllegalArgumentException, GeneralServiceException;

    List<Comment> getTopLevelCommentsOfArticle(Long articleId) throws IllegalArgumentException, GeneralServiceException;

    List<Comment> getTopLevelCommentsOfComment(Comment comment) throws IllegalArgumentException, GeneralServiceException;

    List<Comment> getTopLevelCommentsOfComment(Long commentId) throws IllegalArgumentException, GeneralServiceException;

}
