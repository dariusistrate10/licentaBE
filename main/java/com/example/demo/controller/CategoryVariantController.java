package com.example.demo.controller;

import com.example.demo.model.CategoryVariant;
import com.example.demo.service.CategoryVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/variant/category")
public class CategoryVariantController {
    private final CategoryVariantService categoryVariantService;

    @Autowired
    public CategoryVariantController(CategoryVariantService categoryVariantService) {
        this.categoryVariantService = categoryVariantService;
    }

    @GetMapping
    public List<CategoryVariant> listAllCategoryVariant() {
        return categoryVariantService.listAllCategoryVariant();
    }

    @GetMapping("/find/{id}")
    public Optional<CategoryVariant> findCategoryVariantById(@PathVariable("id") Long id) {
        return categoryVariantService.findCategoryVariantById(id);
    }

    @PostMapping("/add")
    public void addCategoryVariant(@RequestBody CategoryVariant categoryVariant) {
        categoryVariantService.addCategoryVariant(categoryVariant);
    }

    @PutMapping("/update")
    public void updateCategoryVariant(@RequestBody CategoryVariant categoryVariant) {
        categoryVariantService.updateCategoryVariant(categoryVariant);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCategoryVariant(@PathVariable("id") Long id) {
        categoryVariantService.deleteCategoryVariant(id);
    }
}
