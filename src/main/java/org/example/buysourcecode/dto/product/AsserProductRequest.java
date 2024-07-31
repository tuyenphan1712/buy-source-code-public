package org.example.buysourcecode.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AsserProductRequest {

    @Positive
    @NotNull
    private Integer index;

    @NotBlank(message = "Not empty")
    private Long assetId;

}
