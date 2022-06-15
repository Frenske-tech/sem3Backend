package com.example.review;


import com.example.review.model.Review;
import com.example.review.repository.ReviewRepo;
import com.example.review.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import org.springframework.test.web.servlet.ResultActions.*;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;


@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest{

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ReviewRepo repo;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    private ReviewService reviewService;

    @Test
    void GetAllReviews() throws Exception{
        List<Review> review = new ArrayList<>();
        when(reviewService.getAllReviews()).thenReturn(review);

        mvc.perform(get("/review/getall")).andDo(print()).andExpect(status().isOk());
    }
//    @Test
//    void CreateReview() throws Exception{
//        // given - precondition or setup
//        Review review = new Review(1, "tessting", "test", 3);
//
//
//        // when - action or behaviour that we are going test
//        ResultActions response = mvc.perform(post("/review/add")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(review)));
//
//        // then - verify the result or output using assert statements
//        response.andDo(print()).
//                andExpect(status().isCreated())
//                .andExpect(jsonPath("$.post",
//                        is(review.getPost())))
//                .andExpect(jsonPath("$.song",
//                        is(review.getSong())))
//                .andExpect(jsonPath("$.username",
//                        is(post.getUsername())))
//                .andExpect(jsonPath("$.userimage",
//                        is(post.getUserimage())));
//    }
//    @Test
//    void create() throws Exception{
//        Review review = new Review(1, "testing", "test", 3);
//        mvc.perform(post("/review/add/")
//                .contentType(MediaType.ALL)
//                .content(objectMapper.writeValueAsString(review))
//        ).andExpect(status().isOk());
//    }

}
