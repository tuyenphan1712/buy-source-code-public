package org.example.buysourcecode.dto.asset;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class AssetResponse {

    private Long id;
    private String url;
    private String name;
    private String type;
    private Long size;
}
