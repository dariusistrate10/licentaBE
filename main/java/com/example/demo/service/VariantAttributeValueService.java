package com.example.demo.service;

import com.example.demo.model.VariantAttributeValue;
import com.example.demo.repo.VariantAttributeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VariantAttributeValueService {
    private final VariantAttributeValueRepository variantAttributeValueRepository;

    @Autowired
    public VariantAttributeValueService(VariantAttributeValueRepository variantAttributeValueRepository) {
        this.variantAttributeValueRepository = variantAttributeValueRepository;
    }

    public List<VariantAttributeValue> listAllVariantAttributeValue() {
        return variantAttributeValueRepository.findAll();
    }

    public Optional<VariantAttributeValue> findVariantAttributeValueById(Long id) {
        return variantAttributeValueRepository.findById(id);
    }

    public void addVariantAttributeValue(VariantAttributeValue variantAttributeValue) {
        variantAttributeValueRepository.save(variantAttributeValue);
    }

    public void updateVariantAttributeValue(VariantAttributeValue variantAttributeValue) {
        variantAttributeValueRepository.save(variantAttributeValue);
    }

    public void deleteVariantAttributeValue(Long id) {
        variantAttributeValueRepository.deleteById(id);
    }
}
