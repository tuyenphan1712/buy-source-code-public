package org.example.buysourcecode.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CreateProductRequest {
    @NotBlank(message = "not empty")
    String name;

    @NotBlank(message = "not empty")
    String slug;

    String description;

    @NotNull(message = "price not null")
    @PositiveOrZero(message = "price > 0")
    Double price;

    @NotBlank(message = "not empty")
    String createBy;

    @NotEmpty(message = "not empty")
    private List<AsserProductRequest> asserProductRequestList;

}
