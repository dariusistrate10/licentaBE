package com.example.demo.service;

import com.example.demo.model.ProductVariantAttribute;
import com.example.demo.repo.ProductVariantAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductVariantAttributeService {
    private final ProductVariantAttributeRepository productVariantAttributeRepository;

    @Autowired
    public ProductVariantAttributeService(ProductVariantAttributeRepository productVariantAttributeRepository) {
        this.productVariantAttributeRepository = productVariantAttributeRepository;
    }

    public List<ProductVariantAttribute> listAllProductVariantAttribute() {
        return productVariantAttributeRepository.findAll();
    }

    public Optional<ProductVariantAttribute> findProductVariantAttributeById(Long id) {
        return productVariantAttributeRepository.findById(id);
    }

    public void addProductVariantAttribute(ProductVariantAttribute productVariantAttribute) {
        productVariantAttributeRepository.save(productVariantAttribute);
    }

    public void updateProductVariantAttribute(ProductVariantAttribute productVariantAttribute) {
        productVariantAttributeRepository.save(productVariantAttribute);
    }

    public void deleteProductVariantAttribute(Long id) {
        productVariantAttributeRepository.deleteById(id);
    }
}
