package com.example.review;

import com.example.review.controller.ReviewController;
import com.example.review.model.Review;
import com.example.review.repository.ReviewRepo;
import com.example.review.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ReviewApplicationTests {
    @Autowired
    private ReviewController reviewcontroller;
    @Autowired
    private ReviewRepo repo;
    @Autowired
    private ReviewService reviewService;

    @Test
    void contextLoads() throws Exception{
        assertThat(reviewcontroller).isNotNull();
    }
    @Test
    void saveReview(){
        this.repo.save(new Review(1, "test", "testing", 4, "frenske"));
        assertThat(reviewcontroller.getAllReviews().size()).isNotNull();
    }
    @Test
    void getReviews(){
        this.repo.findAll();
        assertThat(reviewcontroller.getAllReviews().size()).isNotNull();
    }
    @Test
    void DelReview(){
        Review review = new Review(6, "test", "testing", 4, "frenske");
        this.repo.save(review);
        this.repo.deleteAll();
        assertThat(reviewcontroller.getAllReviews().size()).isZero();
    }
}
