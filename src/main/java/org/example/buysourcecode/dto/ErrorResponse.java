package org.example.buysourcecode.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private Integer status;
    private String code;
    private String type;
    private String message;
    private Map<String, Object> extraErrors;

}
