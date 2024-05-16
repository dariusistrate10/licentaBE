package com.example.demo.service;

import com.example.demo.model.ProductAttribute;
import com.example.demo.repo.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductAttributeService {
    private final ProductAttributeRepository productAttributeRepository;

    @Autowired
    public ProductAttributeService(ProductAttributeRepository productAttributeRepository) {
        this.productAttributeRepository = productAttributeRepository;
    }

    public List<ProductAttribute> listAllProductAttributes() {
        return productAttributeRepository.findAll();
    }

    public Optional<ProductAttribute> findProductAttributeById(Long id) {
        return productAttributeRepository.findById(id);
    }

    public void addProductAttribute(ProductAttribute productAttribute) {
        productAttributeRepository.save(productAttribute);
    }

    public void updateProductAttribute(ProductAttribute productAttribute) {
        productAttributeRepository.save(productAttribute);
    }

    public void deleteProductAttribute(Long id) {
        productAttributeRepository.deleteById(id);
    }
}
