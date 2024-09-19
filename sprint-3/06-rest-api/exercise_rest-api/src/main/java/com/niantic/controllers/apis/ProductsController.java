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
    @ResponseStatus(value = HttpStatus.CREATED)
    public Product addProduct(@RequestBody Product product) {

        Product newProduct = productDao.addProduct(product);

        return newProduct;

    }

    @PutMapping("/api/products/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable int id, @RequestBody Product product) {

        productDao.updateProduct(id, product);

    }

    @DeleteMapping("/api/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable int id) {

        productDao.deleteProduct(id);

    }

}

