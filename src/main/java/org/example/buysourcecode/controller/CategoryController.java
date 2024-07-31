package org.example.buysourcecode.controller;

import org.example.buysourcecode.dto.category.CategoryReponse;
import org.example.buysourcecode.dto.category.CreateCategoryRequest;
import org.example.buysourcecode.dto.category.UpdateCategoryRequest;
import org.example.buysourcecode.exception.NotFoundException;
import org.example.buysourcecode.map.CategoryMapper;
import org.example.buysourcecode.model.Category;
import org.example.buysourcecode.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public List<CategoryReponse> listAllCategories() {
        List<Category> category = categoryService.findAll();
        List<CategoryReponse> listListAllCategoryReponses = category.stream()
                .map(CategoryMapper::toCategoryReponse)
                .toList();
        return listListAllCategoryReponses;
    }

    //8a33326e-7028-43d7-92a7-c53181ab9d0b
    @GetMapping("/{id}")
    public CategoryReponse getCategoryById(@PathVariable(value = "id") String id) {
        Category category = categoryService.findCategoriesById(id);
        if(category == null) {
            throw new NotFoundException("Category with id: " + id + "not found");
        }
        CategoryReponse categoryReponse = CategoryMapper.toCategoryReponse(category);
        return categoryReponse;
    }


    //ma-001
    @GetMapping("/slug/{slug}")
    public CategoryReponse getCategoryBySlug(@PathVariable(value = "slug") String slug) {
        Category category = categoryService.findCategoryBySlug(slug);
        if(category == null) {
            throw new NotFoundException("Category with slug: " + slug + "not found");
        }
        return CategoryMapper.toCategoryReponse(category);
    }

    @PostMapping
    public CategoryReponse createCategory(@RequestBody CreateCategoryRequest request) {
        Category category = Category.builder()
                .name(request.getName())
                .slug(request.getSlug())
                .build();
        categoryService.createCategory(category);
        return CategoryMapper.toCategoryReponse(category);
    }

    @PutMapping
    public CategoryReponse updateCategory(@RequestBody UpdateCategoryRequest request) {
        Category category = categoryService.findCategoriesById(request.getId());
        category.setName(request.getName());
        category.setSlug(request.getSlug());
        category.setUpdatedAt(LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli());
        categoryService.updateCategory(category);
        return CategoryMapper.toCategoryReponse(category);
    }

    @DeleteMapping("/{id}")
    public CategoryReponse deleteCategory(@PathVariable(value = "id") String id) {
        Category category = categoryService.deleteCategory(id);
        return CategoryMapper.toCategoryReponse(category);
    }

}
