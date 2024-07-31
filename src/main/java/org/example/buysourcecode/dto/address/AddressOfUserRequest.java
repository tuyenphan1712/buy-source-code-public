package org.example.buysourcecode.dto.address;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddressOfUserRequest {

    @NotBlank(message = "Not empty")
    private String userId;

}
