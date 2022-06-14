package com.example.review.controller;

import com.example.review.model.Review;
import com.example.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
//@CrossOrigin
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public String add(@RequestBody Review review){
        reviewService.saveReview(review);
        return "Review added";
    }

    @GetMapping("getall")
    public List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @RequestMapping(method = RequestMethod.DELETE, value ="/{id}")
    public void deleteReview(@PathVariable int id){
        reviewService.deleteReview(id);
    }

}
