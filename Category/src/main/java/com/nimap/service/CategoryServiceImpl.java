package com.nimap.service;

import com.nimap.model.Category;
import com.nimap.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl {

    @Autowired
    private CategoryRepository categoryRepositoryImpl;

    public Category saveData(Category category) {
        return categoryRepositoryImpl.save(category);
    }

    public Optional<Category> findById(int categoryId) {
        return categoryRepositoryImpl.findById(categoryId);
    }

    public List<Category> findAll() {
        return categoryRepositoryImpl.findAll();
    }


    public Category update(Category category) {
        return categoryRepositoryImpl.save(category);
    }

    public void deleteById(int categoryId) {
        categoryRepositoryImpl.deleteById(categoryId);
    }


}
