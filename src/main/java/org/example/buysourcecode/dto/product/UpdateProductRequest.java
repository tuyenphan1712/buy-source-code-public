package org.example.buysourcecode.dto.product;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UpdateProductRequest {

    @NotBlank(message = "Không được phép để trống")
    private String id;

    @NotBlank(message = "Không được phép để trống")
    private String name;

    @NotBlank(message = "Không được phép để trống")
    private String description;

    @PositiveOrZero(message = "Gia lon hon 0")
    @NotNull(message = "Khong Duoc de trong")
    private Double price;

    private List<AsserProductRequest> image;


}
