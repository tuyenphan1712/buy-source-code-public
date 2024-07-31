package org.example.buysourcecode.repository;

import org.example.buysourcecode.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    @Query(value = "select p from Product p where p.status != 'DELETED'")
    List<Product> findAllProduct();

    @Query(value = "select p from Product p where p.status != 'DELETED' and p.id = :id")
    Product findProductById(@Param(value = "id") String id);

    @Query(value = "select p from Product p where p.status != 'DELETED' and p.slug = :slug")
    Product findProductBySlug(@Param(value = "slug") String slug);

}
