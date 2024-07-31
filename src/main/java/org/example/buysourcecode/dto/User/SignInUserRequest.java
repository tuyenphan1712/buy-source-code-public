package org.example.buysourcecode.dto.User;


import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInUserRequest {
    @NotBlank
    private String username;
    private String password;
}
