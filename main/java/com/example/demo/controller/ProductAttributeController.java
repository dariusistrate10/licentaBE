package com.example.demo.controller;

import com.example.demo.model.ProductAttribute;
import com.example.demo.service.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attribute")
public class ProductAttributeController {
    private final ProductAttributeService productAttributeService;

    @Autowired
    public ProductAttributeController(ProductAttributeService productAttributeService) {
        this.productAttributeService = productAttributeService;
    }

    @GetMapping
    public List<ProductAttribute> listAllProductAttributes() {
        return productAttributeService.listAllProductAttributes();
    }

    @GetMapping("/find/{id}")
    public Optional<ProductAttribute> findProductAttributeById(@PathVariable("id") Long id) {
        return productAttributeService.findProductAttributeById(id);
    }

    @PostMapping("/add")
    public void addProductAttribute(@RequestBody ProductAttribute productAttribute) {
        productAttributeService.addProductAttribute(productAttribute);
    }

    @PutMapping("/update")
    public void updateProductAttribute(@RequestBody ProductAttribute productAttribute) {
        productAttributeService.updateProductAttribute(productAttribute);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductAttribute(@PathVariable("id") Long id) {
        productAttributeService.deleteProductAttribute(id);
    }
}
