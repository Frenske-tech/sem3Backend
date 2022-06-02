package com.example.review;

import com.example.review.controller.ReviewController;
import com.example.review.model.Review;
import com.example.review.repository.ReviewRepo;
import com.example.review.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ReviewApplicationTests {
    @Autowired
    private ReviewController reviewcontroller;
    @Autowired
    private ReviewRepo repo;

    @Test
    void contextLoads() throws Exception{
        assertThat(reviewcontroller).isNotNull();
    }
    @Test
    void saveReview(){
        this.repo.save(new Review(1, "test", "testing"));
        assertThat(reviewcontroller.getAllReviews().size()).isNotNull();
    }

}
