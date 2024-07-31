package org.example.buysourcecode.service;

import org.example.buysourcecode.model.Review;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    Review createReview(Review review);
}
