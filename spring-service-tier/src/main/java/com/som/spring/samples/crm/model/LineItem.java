package com.som.spring.samples.crm.model;

import java.io.Serializable;

public class LineItem implements Serializable {
    private Long id;
    private Purchase purchase;
    private Product product;

    public LineItem(Long id, Purchase purchase, Product product) {
        this.id = id;
        this.purchase = purchase;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
