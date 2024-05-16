package com.example.demo.controller;

import com.example.demo.model.VariantAttributeValue;
import com.example.demo.service.VariantAttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product/variant/attribute/value")
@CrossOrigin(origins = "http://localhost:4200/")
public class VariantAttributeValueController {
    private final VariantAttributeValueService variantAttributeValueService;

    @Autowired
    public VariantAttributeValueController(VariantAttributeValueService variantAttributeValueService) {
        this.variantAttributeValueService = variantAttributeValueService;
    }

    @GetMapping
    public List<VariantAttributeValue> listAllVariantAttributeValue() {
        return variantAttributeValueService.listAllVariantAttributeValue();
    }

    @GetMapping("/find/{id}")
    public Optional<VariantAttributeValue> findVariantAttributeValueById(@PathVariable("id") Long id) {
        return variantAttributeValueService.findVariantAttributeValueById(id);
    }

    @PostMapping("/add")
    public void addVariantAttributeValue(@RequestBody VariantAttributeValue variantAttributeValue) {
        variantAttributeValueService.addVariantAttributeValue(variantAttributeValue);
    }

    @PutMapping("/update")
    public void updateVariantAttributeValue(@RequestBody VariantAttributeValue variantAttributeValue) {
        variantAttributeValueService.updateVariantAttributeValue(variantAttributeValue);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVariantAttributeValue(@PathVariable("id") Long id) {
        variantAttributeValueService.deleteVariantAttributeValue(id);
    }
}
