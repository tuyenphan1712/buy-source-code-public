package org.example.buysourcecode.service.impl;

import org.example.buysourcecode.model.Category;
import org.example.buysourcecode.model.Status;
import org.example.buysourcecode.repository.CategoryRepository;
import org.example.buysourcecode.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoriesById(String id) {
        return categoryRepository.findCategoriesById(id);
    }

    @Override
    public Category findCategoryBySlug(String slug) {
        return categoryRepository.findCategoryBySlug(slug);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category deleteCategory(String id) {
        Category category = categoryRepository.findCategoriesById(id);
        category.setStatus(Status.DELETED);
        return categoryRepository.save(category);
    }
}
