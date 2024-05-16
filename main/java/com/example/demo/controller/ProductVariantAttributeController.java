package com.example.demo.controller;

import com.example.demo.model.ProductVariantAttribute;
import com.example.demo.service.ProductVariantAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/product/variant/attribute/list")
public class ProductVariantAttributeController {
    private final ProductVariantAttributeService productVariantAttributeService;

    @Autowired
    public ProductVariantAttributeController(ProductVariantAttributeService productVariantAttributeService) {
        this.productVariantAttributeService = productVariantAttributeService;
    }

    @GetMapping
    public List<ProductVariantAttribute> listAllProductVariantAttribute() {
        return productVariantAttributeService.listAllProductVariantAttribute();
    }

    @GetMapping("/find/{id}")
    public Optional<ProductVariantAttribute> findProductVariantAttributeById(@PathVariable("id") Long id) {
        return productVariantAttributeService.findProductVariantAttributeById(id);
    }

    @PostMapping("/add")
    public void addProductVariantAttribute(@RequestBody ProductVariantAttribute productVariantAttribute) {
        productVariantAttributeService.addProductVariantAttribute(productVariantAttribute);
    }

    @PutMapping("/update")
    public void updateProductVariantAttribute(@RequestBody ProductVariantAttribute productVariantAttribute) {
        productVariantAttributeService.updateProductVariantAttribute(productVariantAttribute);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductVariantAttribute(@PathVariable("id") Long id) {
        productVariantAttributeService.deleteProductVariantAttribute(id);
    }
}
