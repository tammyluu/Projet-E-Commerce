package com.example.ecommerce.service.impl;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entity.Category;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.error.exception.ProductNotFoundException;
import com.example.ecommerce.repository.ICategoryRepository;
import com.example.ecommerce.repository.IProductRepository;
import com.example.ecommerce.service.IBaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;

@Service
public class ProductServiceImpl implements IBaseService<Product> {
<<<<<<< HEAD

    private final IProductRepository productRepository;
    private final ICategoryRepository categoryRepository;
=======
>>>>>>> 3ae5738700ff65bf45cd9a4e4b2879dd11e45898
    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private ICategoryRepository categoryRepository;



    public  Product save (ProductDto dto){
<<<<<<< HEAD
        Product product = Product
                .builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .build();
        return productRepository.save(product);
=======

            Product newProduct = Product
                    .builder()
                    .name(dto.getName())
                    .price(dto.getPrice())
                    .photo(dto.getPhoto())
                    .build();
            return productRepository.save(newProduct);

>>>>>>> 3ae5738700ff65bf45cd9a4e4b2879dd11e45898
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
            existProduct.setPhoto(e.getPhoto());
            try {
                return productRepository.save(existProduct);
            }catch (DataAccessException ex){
                ex.printStackTrace();
            }

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
            newProduct.setPhoto(Dto.getPhoto());
            newProduct.setCategory(category);
            return productRepository.save(newProduct);
        }

    }

    public List<Product> getAllProductsByCategoryId(Long categoryId) {
        return productRepository.findAllByCategory_Id(categoryId);
    }

}
