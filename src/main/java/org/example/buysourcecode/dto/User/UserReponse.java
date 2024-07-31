package org.example.buysourcecode.dto.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserReponse {
    private String id;
    private String username;
    private String comment;
}
