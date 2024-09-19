package com.niantic.services;

import com.niantic.models.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts();

    List<Product> getProductsByCategory(int categoryId);

    Product getProductById(int productId);

    Product addProduct(Product product);

}
