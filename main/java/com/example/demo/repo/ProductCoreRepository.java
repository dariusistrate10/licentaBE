package com.example.demo.repo;

import com.example.demo.model.ProductCore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCoreRepository extends JpaRepository<ProductCore, Long> {
}
