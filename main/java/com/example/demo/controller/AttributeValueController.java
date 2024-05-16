package com.example.demo.controller;

import com.example.demo.model.AttributeValue;
import com.example.demo.service.AttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attributevalue")
public class AttributeValueController {
    private final AttributeValueService attributeValueService;

    @Autowired
    public AttributeValueController(AttributeValueService attributeValueService) {
        this.attributeValueService = attributeValueService;
    }

    @GetMapping
    public List<AttributeValue> listAllAttributeValues() {
        return attributeValueService.listAllAttributeValues();
    }

    @GetMapping("/find/{id}")
    public Optional<AttributeValue> findAttributeValueById(@PathVariable("id") Long id) {
        return attributeValueService.findAttributeValueById(id);
    }

    @PostMapping("/add")
    public void addAttributeValue(@RequestBody AttributeValue attributeValue) {
        attributeValueService.addAttributeValue(attributeValue);
    }

    @PutMapping("/update")
    public void updateAttributeValue(@RequestBody AttributeValue attributeValue) {
        attributeValueService.updateAttributeValue(attributeValue);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAttributeValue(@PathVariable("id") Long id) {
        attributeValueService.deleteAttributeValue(id);
    }
}
