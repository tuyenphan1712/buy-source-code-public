package org.example.buysourcecode.repository;

import org.example.buysourcecode.model.AssetProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetProductRepository extends JpaRepository<AssetProduct, String> {

    @Query(value = "select ap from AssetProduct ap where ap.product.id = :productId and ap.deletedAt is null ")
    List<AssetProduct> findAllByProductId(@Param("productId") String productId);

}
