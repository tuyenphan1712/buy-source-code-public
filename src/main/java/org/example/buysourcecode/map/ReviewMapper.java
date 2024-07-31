package org.example.buysourcecode.map;

import org.example.buysourcecode.dto.review.ReviewResponse;
import org.example.buysourcecode.model.Product;
import org.example.buysourcecode.model.Review;
import org.example.buysourcecode.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;


@Mapper
public interface ReviewMapper {

    @Mapping(source = "createBy", target = "createBy", qualifiedByName = "toUserId")
    @Mapping(source = "product", target = "product", qualifiedByName = "toProductId")
    ReviewResponse toReviewResponse(Review review);

    @Named("toUserId")
    default String toUserId(User user) {
        return user != null ? user.getId() : null;
    }

    @Named("toProductId")
    default String toProductId(Product product) {
        return product != null ? product.getId() : null;
    }

}
