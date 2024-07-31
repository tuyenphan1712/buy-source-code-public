package org.example.buysourcecode.service.impl;

import org.example.buysourcecode.model.Asset;
import org.example.buysourcecode.model.Status;
import org.example.buysourcecode.repository.AssetRepository;
import org.example.buysourcecode.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AssetServiceImpl implements AssetService {

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public Long findMaxId() {
        return assetRepository.findMaxId();
    }

    @Override
    public Asset findById(Long id) {
        return assetRepository.findAssetById(id);
    }

    @Override
    public Asset create(Asset asset) {
        return assetRepository.save(asset);
    }

    @Override
    public Asset delete(Asset asset) {
        asset.setStatus(Status.DELETED);
        return assetRepository.save(asset);
    }
}
