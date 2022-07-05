package com.acrani.course.repositories;

import com.acrani.course.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
