package com.example.demo.repo;

import com.example.demo.model.VariantAttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VariantAttributeValueRepository extends JpaRepository<VariantAttributeValue, Long> {
}
