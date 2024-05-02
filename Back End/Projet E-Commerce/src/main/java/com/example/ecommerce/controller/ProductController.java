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

    @PostMapping(value = "/add", consumes = "multipart/form-data")
    public ResponseEntity<Product> createProduct(@RequestParam("name") String name,
                                                 @RequestParam("price") Double price,
                                                 @RequestParam("file") MultipartFile file) throws IOException {

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String uploadDir = "products-photos/";
        FileUploadUtil.saveFile(uploadDir, fileName, file);

        ProductDto dto = new ProductDto();
        dto.setName(name);
        dto.setPrice(price);
        dto.setPhoto(fileName);

        Product product = productService.save(dto);
        return ResponseEntity.ok(product);
    }


    @PostMapping(value = "/addProductByCategory/{categoryId}", consumes = "multipart/form-data")
    public ResponseEntity<Product> addProductByCategory(@RequestParam("file") MultipartFile file,
                                                        @RequestParam("name") String name,
                                                        @RequestParam("price") Double price,
                                                        @PathVariable Long categoryId) throws IOException {
        // Enregistrer le nouveau fichier image dans le système de fichiers
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        String uploadDir = "products-photos/";
        FileUploadUtil.saveFile(uploadDir, fileName, file);

        ProductDto dto = new ProductDto();
        dto.setName(name);
        dto.setPrice(price);
        dto.setPhoto(fileName);

        // Enregistrer nouveau objet Product  dans la base de données
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


    @PutMapping(value = "/{id}", consumes = "multipart/form-data")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,
                                                 @RequestParam(value = "file", required = false) MultipartFile file,
                                                 @RequestParam("name") String name,
                                                 @RequestParam("price") Double price) throws IOException {


        Product existingProduct = productService.getById(id);
        if (existingProduct == null) {
            return ResponseEntity.notFound().build();
        }

        try {

            String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
            String uploadDir = "products-photos/";
            FileUploadUtil.saveFile(uploadDir, fileName, file);

            // Mettre à jour l'objet Product
            existingProduct.setName(name);
            existingProduct.setPrice(price);
            existingProduct.setPhoto(fileName);

            // Enregistrer l'objet Product mis à jour dans la base de données
            Product updatedProduct = productService.update(existingProduct);

            return ResponseEntity.ok(updatedProduct);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
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
