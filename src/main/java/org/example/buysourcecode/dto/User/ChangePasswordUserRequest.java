package org.example.buysourcecode.dto.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangePasswordUserRequest {
    @NotBlank
    private String username;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*\\d)(?=.*[A-Z]).{8,}$", message = "từ 8 kí tự, có chữ thường, hoa, số")
    private String password;
}
