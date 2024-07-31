package org.example.buysourcecode.dto.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.buysourcecode.dto.asset.AssetResponse;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private Double price;
    private List<AssetResponse> image;
}
