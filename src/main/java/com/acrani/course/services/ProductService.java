package com.acrani.course.services;

import com.acrani.course.entities.ProductEntity;
import com.acrani.course.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public List<ProductEntity> findAll(){
        return productRepository.findAll();
    }
    
    public ProductEntity findById(Long id){
        Optional<ProductEntity> product = productRepository.findById(id);
        return product.get();
    }
}
