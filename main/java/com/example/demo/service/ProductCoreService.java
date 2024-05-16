package com.example.demo.service;

import com.example.demo.model.ProductCore;
import com.example.demo.repo.ProductCoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCoreService {
    private final ProductCoreRepository productCoreRepository;

    @Autowired
    public ProductCoreService(ProductCoreRepository productCoreRepository) {
        this.productCoreRepository = productCoreRepository;
    }

    public List<ProductCore> listAllProductCore() {
        return productCoreRepository.findAll();
    }

    public Optional<ProductCore> findProductCoreById(Long id) {
        return productCoreRepository.findById(id);
    }

    public void addProductCore(ProductCore productCore) {
        productCoreRepository.save(productCore);
    }

    public void updateProductCore(ProductCore productCore) {
        productCoreRepository.save(productCore);
    }

    public void deleteProductCore(Long id) {
        productCoreRepository.deleteById(id);
    }
}
