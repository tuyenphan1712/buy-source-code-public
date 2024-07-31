package org.example.buysourcecode.dto.order;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateOrderDetailRequest {

    @NotBlank(message = "Product ID must not be empty")
    private String productId;

}
