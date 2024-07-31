package org.example.buysourcecode.service;

import org.example.buysourcecode.model.AssetProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AssetProductService {

    List<AssetProduct> getAssetProductsByProductId(String productId);
    AssetProduct deleteAssetProduct(AssetProduct assetProduct);

}
