package com.example.demo.repo;

import com.example.demo.model.ProductVariantAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariantAttributeRepository extends JpaRepository<ProductVariantAttribute, Long> {
}
