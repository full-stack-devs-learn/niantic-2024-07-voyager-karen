package com.niantic.controllers.apis;


import com.niantic.models.Product;
import com.niantic.services.CategoryDao;
import com.niantic.services.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    private final ProductDao productDao;
    private final CategoryDao categoryDao;

    @Autowired
    public ProductsController(ProductDao productDao, CategoryDao categoryDao) {

        this.productDao = productDao;
        this.categoryDao = categoryDao;

    }

    @GetMapping("/api/products")
    public ResponseEntity<List<?>> getProductsByCategory(@RequestParam(value = "catId", required = false) Integer categoryId) {

        try {
            if (categoryId != null) {
                if(categoryDao.getCategory(categoryId) == null) {

                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 404 error
                }

                List<Product> products = productDao.getProductsByCategory(categoryId);
                return ResponseEntity.ok(products); // 200

            } else {

                List<Product> products = productDao.getProducts();
                return ResponseEntity.ok(products);
            }
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // 500 error
        }

    }

    @GetMapping("/api/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable int id) {

        try {
            var product = productDao.getProductById(id);
            if (product == null)
            {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(product);

        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    @PostMapping("/api/products")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<?> addProduct(@RequestBody Product product) {

        try {

        Product newProduct = productDao.addProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);

    } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }

    @PutMapping("/api/products/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestBody Product product) {

        try {
            var currentProduct = productDao.getProducts();
            if(currentProduct == null) {

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }

            productDao.updateProduct(id, product);
            return ResponseEntity.noContent().build();
        }
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }


    @DeleteMapping("/api/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteProduct(@PathVariable int id) {

        try {

             Product product = productDao.getProductById(id);
             if(product == null) {

                 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
             }

             productDao.deleteProduct(id);
             return ResponseEntity.noContent().build();
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

}

