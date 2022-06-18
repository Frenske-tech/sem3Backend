package com.example.review.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String rtext;
    private int reviewScore;
    private String username;

    public Review(int id, String name, String rtext, int reviewScore, String username) {
        this.id = id;
        this.name = name;
        this.rtext = rtext;
        this.reviewScore = reviewScore;
        this.username = username;
    }

    public Review(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRtext() {
        return rtext;
    }

    public void setRtext(String rtext) {
        this.rtext = rtext;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore= reviewScore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {this.username = username;}

}
