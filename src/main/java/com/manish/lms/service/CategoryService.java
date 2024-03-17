package com.manish.lms.service;

 

import java.util.List;

import com.manish.lms.model.Category;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
    Category saveCategory(Category category);
    void deleteCategory(Long id);
}
