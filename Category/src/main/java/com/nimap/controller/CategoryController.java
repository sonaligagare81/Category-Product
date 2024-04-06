package com.nimap.controller;

import com.nimap.exception.RecordNotFoundException;
import com.nimap.model.Category;
import com.nimap.model.Product;
import com.nimap.repository.CategoryRepository;
import com.nimap.repository.ProductRepository;
import com.nimap.service.CategoryServiceImpl;
import com.nimap.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Autowired
    private ProductServiceImpl productServiceImpl;


    @PostMapping("/newCategory")
    public ResponseEntity<Category> saveData(@RequestBody Category category) {

        productServiceImpl.saveAll(category.getProducts());

        return ResponseEntity.ok(categoryServiceImpl.saveData(category));
    }


    @GetMapping("/categoryById/{categoryId}")
    public ResponseEntity<Optional<Category>> findBYId(@PathVariable int categoryId) {
        return ResponseEntity.ok(categoryServiceImpl.findById(categoryId));
    }

    @GetMapping("/allCategories")
    public ResponseEntity<List<Category>> findAll() {
        return ResponseEntity.ok(categoryServiceImpl.findAll());
    }

    @PutMapping("/update/{categoryId}")
    public ResponseEntity<Category> update(@PathVariable int categoryId, @RequestBody Category category) {

        Category category1 = categoryServiceImpl.findById(categoryId).orElseThrow(() -> new RecordNotFoundException("Category ID does not exist"));

        category1.setCategoryName(category.getCategoryName());
        category1.setProducts(category.getProducts());

        return ResponseEntity.ok(categoryServiceImpl.update(category1));

    }

    @DeleteMapping("/deleteById/{categoryId}")
    public ResponseEntity<String> deleteById(@PathVariable int categoryId) {
        categoryServiceImpl.deleteById(categoryId);

        return ResponseEntity.ok("Category Deleted Successfully");
    }

    @PostMapping("/createNewProduct")
    public ResponseEntity<Product> saveData(@RequestBody Product product) {
        return ResponseEntity.ok(productServiceImpl.saveData(product));
    }

    @GetMapping("/productById/{productId}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable int productId) {
        return ResponseEntity.ok(productServiceImpl.findById(productId));
    }

    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> findAllProductData() {
        return ResponseEntity.ok(productServiceImpl.findAll());
    }

    @PutMapping("/updatedata/{productId}")
    public ResponseEntity<Product> findById(@PathVariable int productId, @RequestBody Product product) {

        Product product1 = productServiceImpl.findById(productId).orElseThrow(() -> new RecordNotFoundException("Product ID does not exist"));

        product1.setProductName(product.getProductName());
        product1.setProductPrice(product.getProductPrice());
        product1.setProductLaunchDate(product.getProductLaunchDate());

        return ResponseEntity.ok(productServiceImpl.update(product1));
    }

    @DeleteMapping("/deleteById/{productId}")
    public ResponseEntity<String> deleteByProdId(@PathVariable int productId) {
        productServiceImpl.deleteById(productId);

        return ResponseEntity.ok("Product Data deleted Successfully");
    }


}
