package com.niantic.models;


public class Product {

    private int productId;
    private String productName;
    private int categoryId;

    public Product(int productId, String productName, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}