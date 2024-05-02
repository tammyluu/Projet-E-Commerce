package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long> {
    Product findProductById(Long id);
    List<Product> findAllProductByNameContainingIgnoreCase(String name);
    List<Product> findAllByCategory_Id(Long categoryId);
}
