package com.som.blog.domain;

import com.som.blog.domain.base.DomainObject;

import java.util.List;

/**
 * @author som
 */
// TODO: Article and Comment should have same parent (interface?)
//@Entity
public class Article extends DomainObject {

//    @NotEmpty
    private String topic;

    private String body;

//    @NotNull
    private User author;

    private List<Comment> rootComments;

    public Article(String topic, String body, User author) {
        this.body = body;
        this.author = author;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Comment> getRootComments() {
        return rootComments;
    }

    public void setRootComments(List<Comment> rootComments) {
        this.rootComments = rootComments;
    }
}
