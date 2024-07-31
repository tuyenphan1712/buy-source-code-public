package org.example.buysourcecode.dto.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class CreateReviewRequest {

    @NotBlank(message = "Not empty")
    private String createBy;

    @NotBlank(message = "Not empty")
    private String product;

    @NotBlank(message = "Not empty")
    private String myOrder;

    private String comment;

    @Min(value = 1, message = "rating >= 1")
    @Max(value = 5, message = "rating <= 5")
    private Integer rating;

    private List<Long> image;

}
