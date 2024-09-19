package com.niantic.services;

import com.niantic.models.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts();

    List<Product> getProductsByCategory(int categoryId);

}
