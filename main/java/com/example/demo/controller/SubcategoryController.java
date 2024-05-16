package com.example.demo.controller;

import com.example.demo.model.Subcategory;
import com.example.demo.service.SubcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/variant/subcategory")
public class SubcategoryController {
    private final SubcategoryService subcategoryService;

    @Autowired
    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @GetMapping
    public List<Subcategory> listAllSubcategories() {
        return subcategoryService.listAllSubcategories();
    }

    @GetMapping("/find/{id}")
    public Optional<Subcategory> findSubcategoryById(@PathVariable("id") Long id) {
        return subcategoryService.findSubcategoryById(id);
    }

    @PostMapping("/add")
    public void addSubcategory(@RequestBody Subcategory subcategory) {
        subcategoryService.addSubcategory(subcategory);
    }

    @PutMapping("/update")
    public void updateSubcategory(@RequestBody Subcategory subcategory) {
        subcategoryService.updateSubcategory(subcategory);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSubcategory(@PathVariable("id") Long id) {
        subcategoryService.deleteSubcategory(id);
    }
}
