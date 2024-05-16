package com.example.demo.repo;

import com.example.demo.model.AttributeVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeVariantRepository extends JpaRepository<AttributeVariant, Long> {
}
