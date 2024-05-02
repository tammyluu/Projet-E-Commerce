package com.example.ecommerce.controller;

import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.error.exception.ProductNotFoundException;
import com.example.ecommerce.service.impl.CategoryServiceImpl;
import com.example.ecommerce.service.impl.ProductServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private ProductServiceImpl productService;


    @PostMapping()
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto dto) {
        Category category = categoryService.save(dto);
        return ResponseEntity.ok(category);
    }

    @GetMapping()
    public List<Category> getAllCategories() {
       return  categoryService.getAll().stream().toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        try {
            Category category = categoryService.getById(id);

            return ResponseEntity.ok(category);
        }catch (ProductNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id,@RequestBody Category category) {
        category.setId(id);
        Category updatedCategory = categoryService.update(category);
        if (updatedCategory != null) {
            return ResponseEntity.ok(updatedCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id) {
        try {
            categoryService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{categoryId}/products")
    public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable Long categoryId) {
        try {
            Category categoryExists = categoryService.getById(categoryId);
            if (categoryExists != null) {
                productService.getAllProductsByCategoryId(categoryId);
                return ResponseEntity.ok(productService.getAllProductsByCategoryId(categoryId));
            }
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return null;
    }
}
