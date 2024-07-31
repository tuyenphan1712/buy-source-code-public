package org.example.buysourcecode.service;

import org.example.buysourcecode.model.Asset;
import org.springframework.stereotype.Service;

@Service
public interface AssetService {

    Long findMaxId();
    Asset findById(Long id);
    Asset create(Asset asset);
    Asset delete(Asset asset);

}
