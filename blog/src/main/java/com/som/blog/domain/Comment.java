package com.som.blog.domain;

import com.som.blog.domain.base.DomainObject;

import java.util.List;

/**
 * @author som
 */
//@Entity
public class Comment extends DomainObject {

//    @NotNull
    private Long parentId;

    private List<Comment> children;

//    @NotEmpty
    private String body;

//    @NotNull
    private User author;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<Comment> getChildren() {
        return children;
    }

    public void setChildren(List<Comment> children) {
        this.children = children;
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
}


