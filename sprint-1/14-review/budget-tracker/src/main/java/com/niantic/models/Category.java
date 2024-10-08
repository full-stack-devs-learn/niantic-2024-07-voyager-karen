package com.niantic.models;

public class Category {

    private int categoryId;
    private String name;
    private String description;

    public Category(){

    }

    public Category(int categoryId, String name, String description) {
        this.description = description;
        this.name = name;
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return String.format("%2d: Name - %s, Description - %s\n", categoryId, name, description);
    }


}

