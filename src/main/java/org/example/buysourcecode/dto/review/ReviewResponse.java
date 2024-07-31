package org.example.buysourcecode.dto.review;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.example.buysourcecode.dto.asset.AssetResponse;


import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class ReviewResponse {

    private String id;

    private String createBy;

    private String product;

    private String comment;

    private Integer rating;

    private List<AssetResponse> image;

}
