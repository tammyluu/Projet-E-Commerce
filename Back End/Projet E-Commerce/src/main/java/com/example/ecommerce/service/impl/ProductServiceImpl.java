package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.error.exception.ProductNotFoundException;
import com.example.ecommerce.repository.ICategoryRepository;
import com.example.ecommerce.repository.IProductRepository;
import com.example.ecommerce.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IBaseService<Product> {

    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;
    @Autowired
    public ProductServiceImpl(IProductRepository productRepository,ICategoryRepository categoryRepository)
    {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    public  Product save (ProductDto dto){
        Product product = Product
                .builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .build();
        return productRepository.save(product);
    }


    @Override
    public Product create(Product e) {
        return productRepository.save(e);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public Product update(Product e) {
        Product existProduct = productRepository.findProductById(e.getId());
        if (existProduct != null) {
            existProduct.setName(e.getName());
            existProduct.setPrice(e.getPrice());
            return productRepository.save(existProduct);
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        Product existProduct = productRepository.findProductById(id);
        if (existProduct != null) {
            productRepository.delete(existProduct);
        }else {
            throw new ProductNotFoundException(id);
        }

    }
    public List<Product> getAllProductsByName(String name) {
        return productRepository.findAllProductByNameContainingIgnoreCase(name);
    }

    public Product addProductByCategory(ProductDto Dto, Long categoryId) {
        Category category = categoryRepository.findCategoriesById(categoryId);
        Product existingProduct = productRepository.findProductById(Dto.getId());
        if (existingProduct != null) {
            existingProduct.setCategory(category);
            return productRepository.save(existingProduct);
        }else {
            Product newProduct = new Product();
            newProduct.setName(Dto.getName());
            newProduct.setPrice(Dto.getPrice());
            newProduct.setCategory(category);
            return productRepository.save(newProduct);
        }

    }

}
