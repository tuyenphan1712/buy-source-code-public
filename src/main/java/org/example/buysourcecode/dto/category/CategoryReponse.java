package org.example.buysourcecode.dto.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class CategoryReponse {
    private String id;
    private String name;
    private String slug;
    private Long createdAt;
    private Long updatedAt;
    private String status;
}
