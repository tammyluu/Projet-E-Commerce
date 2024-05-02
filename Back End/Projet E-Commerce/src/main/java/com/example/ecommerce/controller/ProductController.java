package com.example.ecommerce.controller;

import com.example.ecommerce.dto.ProductDto;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.error.exception.ProductNotFoundException;
import com.example.ecommerce.service.impl.ProductServiceImpl;
import com.example.ecommerce.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

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
    public ResponseEntity<Product> createProduct(@RequestBody ProductDto dto, @RequestParam("image") MultipartFile file) throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "products-photos/";
        FileUploadUtil.saveFile(uploadDir,fileName,file);
        Product newProduct = productService.save(dto);
        newProduct.setPhoto(fileName);
        return ResponseEntity.ok(newProduct);
    }


   /* @PostMapping(value = "/addProductByCategory/{categoryId}", consumes = "multipart/form-data")
    public ResponseEntity<Product> addProductByCategory(@RequestBody ProductDto dto, @PathVariable Long categoryId, @RequestParam("image") MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String uploadDir = "products-photos/";
        FileUploadUtil.saveFile(uploadDir,fileName,file);
        Product product = productService.addProductByCategory(dto, categoryId);
        return ResponseEntity.ok(product);
    }*/

    @PostMapping(value = "/addProductByCategory/{categoryId}", consumes = "multipart/form-data")
    public ResponseEntity<Product> addProductByCategory(@RequestParam("file") MultipartFile file,
                                                        @RequestParam("name") String name,
                                                        @RequestParam("price") Double price,
                                                        @PathVariable Long categoryId) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String uploadDir = "products-photos/";
        FileUploadUtil.saveFile(uploadDir, fileName, file);

        ProductDto dto = new ProductDto();
        dto.setName(name);
        dto.setPrice(price);
        dto.setPhoto(fileName);

        Product product = productService.addProductByCategory(dto, categoryId);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/byName")
    public ResponseEntity<List<Product>> getProductsByName(@RequestParam String name) {
        List<Product> products = productService.getAllProductsByName(name);
        if (products.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        product.setId(id);
        Product updatedProduct = productService.update(product);
        if (updatedProduct != null) {
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id) {
        try {
            productService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ProductNotFoundException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
