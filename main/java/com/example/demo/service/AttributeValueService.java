package com.example.demo.service;

import com.example.demo.model.AttributeValue;
import com.example.demo.repo.AttributeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeValueService {
    private final AttributeValueRepository attributeValueRepository;

    @Autowired
    public AttributeValueService(AttributeValueRepository attributeValueRepository) {
        this.attributeValueRepository = attributeValueRepository;
    }

    public List<AttributeValue> listAllAttributeValues() {
        return attributeValueRepository.findAll();
    }

    public Optional<AttributeValue> findAttributeValueById(Long id) {
        return attributeValueRepository.findById(id);
    }

    public void addAttributeValue(AttributeValue attributeValue) {
        attributeValueRepository.save(attributeValue);
    }

    public void updateAttributeValue(AttributeValue attributeValue) {
        attributeValueRepository.save(attributeValue);
    }

    public void deleteAttributeValue(Long id) {
        attributeValueRepository.deleteById(id);
    }
}
