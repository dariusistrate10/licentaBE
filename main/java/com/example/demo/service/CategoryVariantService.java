package com.example.demo.service;

import com.example.demo.model.CategoryVariant;
import com.example.demo.repo.CategoryVariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryVariantService {
    private final CategoryVariantRepository categoryVariantRepository;

    @Autowired
    public CategoryVariantService(CategoryVariantRepository categoryVariantRepository) {
        this.categoryVariantRepository = categoryVariantRepository;
    }

    public List<CategoryVariant> listAllCategoryVariant() {
        return categoryVariantRepository.findAll();
    }

    public Optional<CategoryVariant> findCategoryVariantById(Long id) {
        return categoryVariantRepository.findById(id);
    }

    public void addCategoryVariant(CategoryVariant categoryVariant) {
        categoryVariantRepository.save(categoryVariant);
    }

    public void updateCategoryVariant(CategoryVariant categoryVariant) {
        categoryVariantRepository.save(categoryVariant);
    }

    public void deleteCategoryVariant(Long id) {
        categoryVariantRepository.deleteById(id);
    }
}
