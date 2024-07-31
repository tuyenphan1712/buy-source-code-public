package org.example.buysourcecode.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.buysourcecode.model.AssetProduct;
import org.example.buysourcecode.repository.AssetProductRepository;
import org.example.buysourcecode.service.AssetProductService;
import org.example.buysourcecode.util.DateTimeUtil;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AssetProductServiceImpl implements AssetProductService {

    private final AssetProductRepository assetProductRepository;

    @Override
    public List<AssetProduct> getAssetProductsByProductId(String productId) {
        return assetProductRepository.findAllByProductId(productId);
    }

    @Override
    public AssetProduct deleteAssetProduct(AssetProduct assetProduct) {
        assetProduct.setDeletedAt(DateTimeUtil.toEpochSecond(LocalDateTime.now()));
        return assetProductRepository.save(assetProduct);
    }
}
