package org.example.buysourcecode.service;

import org.example.buysourcecode.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> findAll();
    Category findCategoriesById(String id);
    Category findCategoryBySlug(String slug);
    Category createCategory(Category category);
    Category updateCategory(Category category);
    Category deleteCategory(String id);

}
