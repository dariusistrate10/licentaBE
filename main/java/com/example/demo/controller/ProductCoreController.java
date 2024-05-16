package com.example.demo.controller;

import com.example.demo.model.ProductCore;
import com.example.demo.service.ProductCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/product/core")
public class ProductCoreController {
    private final ProductCoreService productCoreService;

    @Autowired
    public ProductCoreController(ProductCoreService productCoreService) {
        this.productCoreService = productCoreService;
    }

    @GetMapping
    public List<ProductCore> listAllProductCore() {
        return  productCoreService.listAllProductCore();
    }

    @GetMapping("/find/{id}")
    public Optional<ProductCore> findProductCoreById(@PathVariable("id") Long id) {
        return productCoreService.findProductCoreById(id);
    }

    @PostMapping("/add")
    public void addProductCore(@RequestBody ProductCore productCore) {
        productCoreService.addProductCore(productCore);
    }

    @PutMapping("/update")
    public void updateProductCore(@RequestBody ProductCore productCore) {
        productCoreService.updateProductCore(productCore);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductCore(@PathVariable("id") Long id) {
        productCoreService.deleteProductCore(id);
    }
}
