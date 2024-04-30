package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.Category;
import com.example.ecommerce.service.IBaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements IBaseService<Category> {
    @Override
    public Category create(Category e) {
        return null;
    }

    @Override
    public List<Category> getAll() {
        return List.of();
    }

    @Override
    public Category getById(Long id) {
        return null;
    }

    @Override
    public Category update(Category e) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
