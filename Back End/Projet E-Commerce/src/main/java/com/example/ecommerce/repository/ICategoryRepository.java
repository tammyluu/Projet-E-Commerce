package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findCategoryByName(String categoryName);
    Category findById(long id);

}
