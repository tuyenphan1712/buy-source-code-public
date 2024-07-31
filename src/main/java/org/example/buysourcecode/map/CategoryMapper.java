package org.example.buysourcecode.map;

import org.example.buysourcecode.dto.category.CategoryReponse;
import org.example.buysourcecode.model.Category;

public class CategoryMapper {

    public static CategoryReponse toCategoryReponse(Category category) {
        return CategoryReponse.builder()
                .id(category.getId())
                .name(category.getName())
                .slug(category.getSlug())
                .createdAt(category.getCreatedAt())
                .updatedAt(category.getUpdatedAt())
                .status(category.getStatus().name())
                .build();
    }

}
