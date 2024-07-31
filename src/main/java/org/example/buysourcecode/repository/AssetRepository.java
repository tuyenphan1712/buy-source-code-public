package org.example.buysourcecode.repository;

import org.example.buysourcecode.model.Asset;
import org.springframework.boot.autoconfigure.jackson.JacksonProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

    @Query(value = "select a from Asset a where a.id = :id and a.status != 'DELETED'")
    Asset findAssetById(@Param("id") Long id);

    @Query(value = "select max(a.id) from Asset a")
    Long findMaxId();



}
