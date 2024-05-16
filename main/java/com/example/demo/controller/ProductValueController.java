package com.example.demo.controller;

import com.example.demo.model.ProductValue;
import com.example.demo.service.ProductValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/productvalue")
public class ProductValueController {
    private final ProductValueService productValueService;

    @Autowired
    public ProductValueController(ProductValueService productValueService) {
        this.productValueService = productValueService;
    }

    @GetMapping
    public List<ProductValue> listAllProductValue() {
        return productValueService.listAllProductValue();
    }

    @GetMapping("/find/{id}")
    public Optional<ProductValue> findProductValueById(@PathVariable("id") Long id) {
        return productValueService.findProductValueById(id);
    }

    @PostMapping("/add")
    public void addProductValue(@RequestBody ProductValue productValue) {
        productValueService.addProductValue(productValue);
    }

    @PutMapping("/update")
    public void updateProductValue(@RequestBody ProductValue productValue) {
        productValueService.updateProductValue(productValue);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProductValue(@PathVariable("id") Long id) {
        productValueService.deleteProductValue(id);
    }
}
