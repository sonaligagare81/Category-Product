package com.nimap.service;


import com.nimap.model.Product;
import com.nimap.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl {


    @Autowired
    private ProductRepository productRepositoryImpl;

    public Product saveData(Product product) {
        return productRepositoryImpl.save(product);
    }

    public Optional<Product> findById(int productId) {
        return productRepositoryImpl.findById(productId);
    }

    public List<Product> findAll() {
        return productRepositoryImpl.findAll();
    }

    public Product update(Product product) {
        return productRepositoryImpl.save(product);
    }

    public void deleteById(int productId) {
        productRepositoryImpl.deleteById(productId);
    }


    public List<Product> saveAll(List<Product> products) {

        return productRepositoryImpl.saveAll(products);
    }
}
