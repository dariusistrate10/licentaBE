package com.example.demo.controller;

import com.example.demo.model.ProductVariant;
import com.example.demo.service.ProductVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/product/variant")
public class ProductVariantController {
    private final ProductVariantService productVariantService;

    @Autowired
    public ProductVariantController(ProductVariantService productVariantService) {
        this.productVariantService = productVariantService;
    }

    @GetMapping
    public List<ProductVariant> listAllProductVariant() {
        return productVariantService.listAllProductVariant();
    }

    @GetMapping("/filter/{minPrice}/{maxPrice}")
    public List<ProductVariant> listAllProductVariantsByPrice(@PathVariable("minPrice") Long minPrice, @PathVariable("maxPrice") Long maxPrice) {
        return productVariantService.listAllProductVariantsByPrice(minPrice, maxPrice);
    }

    @GetMapping("/filter/{categoryId}")
    public List<ProductVariant> listAllProductVariantsByCategory(@PathVariable("categoryId") Long categoryId) {
        return productVariantService.listAllProductVariantsByCategory(categoryId);
    }

    @GetMapping("/find/{id}")
    public Optional<ProductVariant> findProductVariantById(@PathVariable("id") Long id) {
        return productVariantService.findProductVariantById(id);
    }

    @PostMapping("/add")
    public void addProductVariant(@RequestBody ProductVariant productVariant) {
        productVariantService.addProductVariant(productVariant);
    }

    @PutMapping("/update")
    public void updateProductVariant(@RequestBody ProductVariant productVariant) {
        productVariantService.updateProductVariant(productVariant);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductVariant(@PathVariable("id") Long id) {
        productVariantService.deleteProductVariant(id);
    }
}
