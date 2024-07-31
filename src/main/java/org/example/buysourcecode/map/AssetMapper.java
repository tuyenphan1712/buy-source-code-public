package org.example.buysourcecode.map;


import org.example.buysourcecode.dto.asset.AssetResponse;
import org.example.buysourcecode.model.Asset;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
public interface AssetMapper {

    AssetResponse toAssetResponse(Asset asset);

}
