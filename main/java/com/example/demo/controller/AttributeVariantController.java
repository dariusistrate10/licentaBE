package com.example.demo.controller;

import com.example.demo.model.AttributeVariant;
import com.example.demo.service.AttributeVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product/variant/attribute")
@CrossOrigin(origins = "http://localhost:4200/")
public class AttributeVariantController {
    private final AttributeVariantService attributeVariantService;

    @Autowired
    public AttributeVariantController(AttributeVariantService attributeVariantService) {
        this.attributeVariantService = attributeVariantService;
    }

    @GetMapping
    public List<AttributeVariant> listAllAttributeVariants() {
        return attributeVariantService.listAllAttributeVariants();
    }

    @GetMapping("/find/{id}")
    public Optional<AttributeVariant> findAttributeVariantById(@PathVariable("id") Long id) {
        return attributeVariantService.findAttributeVariantById(id);
    }

    @PostMapping("/add")
    public void addAttributeVariant(@RequestBody AttributeVariant attributeVariant) {
        attributeVariantService.addAttributeVariant(attributeVariant);
    }

    @PutMapping("/update")
    public void updateAttributeVariant(@RequestBody AttributeVariant attributeVariant) {
        attributeVariantService.updateAttributeVariant(attributeVariant);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAttributeVariant(@PathVariable("id") Long id) {
        attributeVariantService.deleteAttributeVariant(id);
    }
}
