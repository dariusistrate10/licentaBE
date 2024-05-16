package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.listAllProducts();
    }

    @GetMapping("/filtru/{minPrice}/{maxPrice}")
    public List<Product> listAllProductsByPrice(@PathVariable("minPrice") Long minPrice, @PathVariable("maxPrice") Long maxPrice) {
        return productService.listAllProductsByPrice(minPrice, maxPrice);
    }

    @GetMapping("/find/{id}")
    public Optional<Product> findProductById(@PathVariable("id") Long id) {
        return productService.findProductById(id);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("/update")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
    }
}
