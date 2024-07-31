package org.example.buysourcecode.map;

import org.example.buysourcecode.dto.asset.AssetResponse;
import org.example.buysourcecode.model.Asset;
import org.example.buysourcecode.service.CloudStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssetMapperImplements implements AssetMapper {

    @Autowired
    private CloudStorageService cloudStorageService;

    @Override
    public AssetResponse toAssetResponse(Asset asset) {
        return AssetResponse.builder()
                .id(asset.getId())
                .url(cloudStorageService.getUrl(asset.getPath()))
                .name(asset.getName())
                .type(asset.getType())
                .size(asset.getSize())
                .build();
    }
}
