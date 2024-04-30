package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.error.exception.ProductNotFoundException;
import com.example.ecommerce.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("")
    public List<Product> getAllProducts() {
        return productService.getAll().stream().toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        try {
            Product product =productService.getById(id);
            return ResponseEntity.ok(product);
        }catch (ProductNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto dto) {
        Product newProduct = productService.save(dto);
        return ResponseEntity.ok(newProduct);
    }
    @GetMapping("/byName")
    public ResponseEntity<List<Product>> getProductsByName(@RequestParam String name) {
        List<Product> products = productService.getAllProductsByName(name);
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }
    @GetMapping("/byPrice")
    public ResponseEntity<List<Product>> getProductsByPrice(@RequestParam double price) {
        List<Product> products = productService.getAllProductsByPrice(price);
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }

}
