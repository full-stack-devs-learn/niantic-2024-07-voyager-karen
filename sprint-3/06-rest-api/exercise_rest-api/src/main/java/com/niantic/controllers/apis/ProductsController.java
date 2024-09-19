package com.niantic.controllers.apis;


import com.niantic.models.Product;
import com.niantic.services.MySqlProductDao;
import com.niantic.services.ProductDao;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    private ProductDao productDao = new MySqlProductDao();


    @GetMapping("/api/products")
    public List<Product> getProductsByCategory(@RequestParam(value = "catId", required = false) Integer categoryId) {

        if (categoryId != null) {
            return productDao.getProductsByCategory(categoryId);
        } else {
            return productDao.getProducts();
        }

    }

    @GetMapping("/api/products/{id}")
    public Product getProductById(@PathVariable int id) {

        return productDao.getProductById(id);
    }

    @PostMapping("/api/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {

        return productDao.addProduct(product);

    }

}
