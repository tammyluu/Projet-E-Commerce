package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.CategoryDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.repository.ICategoryRepository;
import com.example.ecommerce.service.IBaseService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements IBaseService<Category> {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public Category create(Category e) {
        return categoryRepository.save(e);
    }
    public Category save(CategoryDto dto) {
        Category category = Category.builder()
                .name(dto.getName())
                .build();
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findCategoriesById(id);
    }

    @Override
    public Category update(Category e) {
        Category existCategory = categoryRepository.findCategoriesById(e.getId());
        if (existCategory != null) {
            existCategory.setName(e.getName());
            return categoryRepository.save(existCategory);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Category existCategory = categoryRepository.findCategoriesById(id);
        if (existCategory != null) {
            categoryRepository.delete(existCategory);
        }else {
            throw new EntityNotFoundException("Category id not found");
        }
    }
}
