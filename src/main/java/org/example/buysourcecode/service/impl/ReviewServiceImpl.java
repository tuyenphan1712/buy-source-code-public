package org.example.buysourcecode.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.buysourcecode.model.Review;
import org.example.buysourcecode.repository.ReviewRepository;
import org.example.buysourcecode.service.ReviewService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }
}
