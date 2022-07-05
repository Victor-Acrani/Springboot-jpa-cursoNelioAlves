package com.acrani.course.resources;

import com.acrani.course.entities.ProductEntity;
import com.acrani.course.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {

    private final ProductService productService;

    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> findAll(){
        List<ProductEntity> allProducts = productService.findAll();
        return ResponseEntity.ok().body(allProducts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductEntity> findById(@PathVariable Long id){
        ProductEntity product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
