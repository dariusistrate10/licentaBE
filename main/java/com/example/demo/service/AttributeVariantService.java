package com.example.demo.service;

import com.example.demo.model.AttributeVariant;
import com.example.demo.repo.AttributeVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeVariantService {
    private final AttributeVariantRepository attributeVariantRepository;

    @Autowired
    public AttributeVariantService(AttributeVariantRepository attributeVariantRepository) {
        this.attributeVariantRepository = attributeVariantRepository;
    }

    public List<AttributeVariant> listAllAttributeVariants() {
        return attributeVariantRepository.findAll();
    }

    public Optional<AttributeVariant> findAttributeVariantById(Long id) {
        return attributeVariantRepository.findById(id);
    }

    public void addAttributeVariant(AttributeVariant attributeVariant) {
        attributeVariantRepository.save(attributeVariant);
    }

    public void updateAttributeVariant(AttributeVariant attributeVariant) {
        attributeVariantRepository.save(attributeVariant);
    }

    public void deleteAttributeVariant(Long id) {
        attributeVariantRepository.deleteById(id);
    }
}
