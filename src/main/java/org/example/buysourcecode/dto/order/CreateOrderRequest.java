package org.example.buysourcecode.dto.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CreateOrderRequest {

    @NotBlank(message = "User ID must not be empty")
    private String userId;

    @NotEmpty(message = "Not empty")
    private List<CreateOrderDetailRequest> orderDetails;

}
