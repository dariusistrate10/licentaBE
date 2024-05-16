package com.example.demo.repo;

import com.example.demo.model.CartEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartEntryRepository extends JpaRepository<CartEntry, Long> {
    List<CartEntry> findByCartId(Long cartId);
}
