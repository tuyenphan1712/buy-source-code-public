package org.example.buysourcecode.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.buysourcecode.dto.asset.AssetResponse;
import org.example.buysourcecode.dto.review.CreateReviewRequest;
import org.example.buysourcecode.dto.review.ReviewResponse;
import org.example.buysourcecode.exception.InvalidException;
import org.example.buysourcecode.exception.NotFoundException;
import org.example.buysourcecode.map.AssetMapper;
import org.example.buysourcecode.map.ReviewMapper;
import org.example.buysourcecode.model.*;
import org.example.buysourcecode.service.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;
    private final UserService userService;
    private final OrderService orderService;
    private final ProductService productService;
    private final AssetService assetService;
    private final AssetMapper assetMapper;


    @PostMapping("/create")
    public ReviewResponse create(@RequestBody @Valid CreateReviewRequest createReviewRequest) {

        User user = userService.findUserById(createReviewRequest.getCreateBy());
        if(user == null) {throw new NotFoundException(String.format("User with id %s not found", createReviewRequest.getCreateBy()));}

        Order order = orderService.getOrderById(createReviewRequest.getMyOrder());
        if(order == null) {throw new NotFoundException(String.format("Order with id %s not found", createReviewRequest.getMyOrder()));}

        if(!checkOrder(order, createReviewRequest.getProduct())) {throw new InvalidException("Order invalid");}

        Review review = Review.builder()
                .order(order)
                .product(productService.getProductById(createReviewRequest.getProduct()))
                .comment(createReviewRequest.getComment())
                .createBy(user)
                .rating(createReviewRequest.getRating())
                .build();

        List<AssetReview> imgDescription = new ArrayList<>();

        List<AssetResponse> assetResponses = new ArrayList<>();

        if(createReviewRequest.getImage() != null ) {

            createReviewRequest.getImage().forEach(item->{

                Asset asset = assetService.findById(item);
                if(asset == null) {throw new NotFoundException(String.format("Asset with id %s not found", item));}

                    AssetReview assetReview = AssetReview.builder()
                            .asset(asset)
                            .review(review)
                            .build();

                AssetResponse assetResponse = assetMapper.toAssetResponse(asset);

                assetResponses.add(assetResponse);

                imgDescription.add(assetReview);
            });
        }

        review.setImgDescription(imgDescription);

        reviewService.createReview(review);

        ReviewResponse reviewResponse = reviewMapper.toReviewResponse(review);

        reviewResponse.setImage(assetResponses);

        return reviewResponse;
    }

    public boolean checkOrder(Order order, String productId) {
        return order.getOrderDetails().stream()
                .anyMatch(item -> item.getProduct().getId().equals(productId));
    }

}
