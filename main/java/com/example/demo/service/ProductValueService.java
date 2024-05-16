package com.example.demo.service;

import com.example.demo.model.ProductValue;
import com.example.demo.repo.ProductValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductValueService {
    private final ProductValueRepository productValueRepository;

    @Autowired
    public ProductValueService(ProductValueRepository productValueRepository) {
        this.productValueRepository = productValueRepository;
    }

    public List<ProductValue> listAllProductValue() {
        return productValueRepository.findAll();
    }

    public Optional<ProductValue> findProductValueById(Long id) {
        return productValueRepository.findById(id);
    }

    public void addProductValue(ProductValue productValue) {
        productValueRepository.save(productValue);
    }

    public void updateProductValue(ProductValue productValue) {
        productValueRepository.save(productValue);
    }

    public void deleteProductValue(Long id) {
        productValueRepository.deleteById(id);
    }
}
