package org.example.buysourcecode.dto.User;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class SignUpUserRequest {

    @NotBlank(message = "email không được để trống")
    @Email(message = "Phai la email")
    private String mail;

    @NotBlank(message = "username không được để trống")
    @Size(min = 6, max = 16, message = "username có độ dài từ 6-16 kí tự")
    private String username;

    @NotNull
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$", message = "từ 8 kí tự, có chữ thường, hoa, số")
    private String password;
}
