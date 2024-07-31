package org.example.buysourcecode.dto.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CreateCategoryRequest {
    private String name;
    private String slug;
}
