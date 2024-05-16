package com.example.demo.service;

import com.example.demo.model.Subcategory;
import com.example.demo.repo.SubcategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;

    @Autowired
    public SubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    public List<Subcategory> listAllSubcategories() {
        return subcategoryRepository.findAll();
    }

    public Optional<Subcategory> findSubcategoryById(Long id) {
        return subcategoryRepository.findById(id);
    }

    public void addSubcategory(Subcategory subcategory) {
        subcategoryRepository.save(subcategory);
    }

    public void updateSubcategory(Subcategory subcategory) {
        subcategoryRepository.save(subcategory);
    }

    public void deleteSubcategory(Long id) {
        subcategoryRepository.deleteById(id);
    }
}
