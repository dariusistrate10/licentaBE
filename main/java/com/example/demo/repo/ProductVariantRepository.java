package com.example.demo.repo;

import com.example.demo.model.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {
    List<ProductVariant> findByPriceBetween(Long minPrice, Long maxPrice);
    List<ProductVariant> findByCategoryVariantId(Long caregoryVariantId);
}
