package org.example.buysourcecode.dto.address;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateAddressRequest {

    @NotBlank(message = "Not empty")
    private String street;

    @NotBlank(message = "Not empty")
    private Integer town;

    @NotBlank(message = "Not empty")
    private String userId;

}
