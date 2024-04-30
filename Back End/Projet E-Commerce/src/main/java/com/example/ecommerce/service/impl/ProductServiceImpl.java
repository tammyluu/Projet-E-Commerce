package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.error.exception.ProductNotFoundException;
import com.example.ecommerce.repository.IProductRepository;
import com.example.ecommerce.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IBaseService<Product> {

    private IProductRepository productRepository;
    @Autowired
    public ProductServiceImpl(IProductRepository productRepository) {
        this.productRepository = productRepository;
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
        return productRepository.findAllProductByName(name);
    }
    public List<Product> getAllProductsByPrice(Double price) {
        return productRepository.findAllProductByPrice(price);
    }

}