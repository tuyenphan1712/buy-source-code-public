package org.example.buysourcecode.dto.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OrderResponse {
    String id;
    String userId;
    String status;
}
