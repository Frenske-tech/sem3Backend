package com.example.review.service;

import com.example.review.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    public Review saveReview(Review review);
    public List<Review> getAllReviews();
}
