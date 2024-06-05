package com.example.demo.service;

import com.example.demo.model.Review;
import com.example.demo.model.User;
import com.example.demo.repo.AddressRepository;
import com.example.demo.repo.CartRepository;
import com.example.demo.repo.ReviewRepository;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> listAllReviews() {
        return reviewRepository.findAll();
    }

    public void addReview(Review review) {
        reviewRepository.save(review);
    }
}
