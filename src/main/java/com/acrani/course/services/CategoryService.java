package com.acrani.course.services;

import com.acrani.course.entities.CategoryEntity;
import com.acrani.course.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryEntity> findAll(){
        return categoryRepository.findAll();
    }

    public CategoryEntity findById(Long id){
        Optional<CategoryEntity> category = categoryRepository.findById(id);
        return category.get();
    }
}
