package com.example.demo.service;

import com.example.demo.model.ProductVariant;
import com.example.demo.model.Review;
import com.example.demo.repo.ProductVariantRepository;
import com.example.demo.repo.ReviewRepository;
import org.hibernate.sql.results.graph.FetchList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductVariantService {
    private final ProductVariantRepository productVariantRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public ProductVariantService(ProductVariantRepository productVariantRepository, ReviewRepository reviewRepository) {
        this.productVariantRepository = productVariantRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<ProductVariant> listAllProductVariant() {
        return productVariantRepository.findAll();
    }

    public List<ProductVariant> listAllProductVariantsByPrice(Long minPrice, Long maxPrice) {
        return productVariantRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<ProductVariant> listAllProductVariantsByCategory(Long categoryId) {
        return productVariantRepository.findByCategoryVariantId(categoryId);
    }

    public Optional<ProductVariant> findProductVariantById(Long id) {
        return productVariantRepository.findById(id);
    }

    public void addProductVariant(ProductVariant productVariant) {
        productVariantRepository.save(productVariant);
    }

    public void updateProductVariant(ProductVariant productVariant) {
        productVariantRepository.save(productVariant);
    }

    public void deleteProductVariant(Long id) {
        productVariantRepository.deleteById(id);
    }

    public Review saveReview(Long productVariantId, Review review) {
        ProductVariant productVariant = productVariantRepository.findById(productVariantId).orElseThrow(() -> new RuntimeException("Product variant not found"));
        review.setProductVariant(productVariant);
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByProductVariantId(Long productVariantId) {
        return productVariantRepository.findById(productVariantId).orElseThrow(() -> new RuntimeException("Product variant not found")).getReviews();
    }
}
