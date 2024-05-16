package com.example.demo.service;

import com.example.demo.model.ProductVariant;
import com.example.demo.repo.ProductVariantRepository;
import org.hibernate.sql.results.graph.FetchList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductVariantService {
    private final ProductVariantRepository productVariantRepository;

    @Autowired
    public ProductVariantService(ProductVariantRepository productVariantRepository) {
        this.productVariantRepository = productVariantRepository;
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
}
