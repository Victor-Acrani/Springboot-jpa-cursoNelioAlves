package com.acrani.course.resources;

import com.acrani.course.entities.CategoryEntity;
import com.acrani.course.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class EntityResource {

    private final CategoryService categoryService;

    public EntityResource(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryEntity>> findAll(){
        List<CategoryEntity> allCategories = categoryService.findAll();
        return ResponseEntity.ok().body(allCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryEntity> findById(@PathVariable Long id){
        CategoryEntity category = categoryService.findById(id);
        return ResponseEntity.ok().body(category);
    }
}
