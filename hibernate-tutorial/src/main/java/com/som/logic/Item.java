package com.som.logic;

/**
 * @author som
 */
public class Item {
    private Long id;

    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void moveToCategory(Category category) {
        this.getCategory().getItems().remove(this);
        this.setCategory(category);
    }
}
