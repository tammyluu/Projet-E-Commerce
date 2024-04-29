package com.example.ecommerce.service.impl;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.IBaseService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service    
public class ProductService implements IBaseService<Product> {
    @Override
    public Product createNew(Product e) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product getById(Long id) {
        return null;
    }

    @Override
    public Product update(Product e) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
