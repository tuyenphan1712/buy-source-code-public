package org.example.buysourcecode.map;

import org.example.buysourcecode.dto.product.CreateProductRequest;
import org.example.buysourcecode.dto.product.ProductResponse;
import org.example.buysourcecode.dto.product.UpdateProductRequest;
import org.example.buysourcecode.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

//    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

    ProductResponse toProductResponse(Product product);

    @Mapping(target = "createBy", ignore = true)
    Product toProduct(CreateProductRequest createProductRequest);

}
