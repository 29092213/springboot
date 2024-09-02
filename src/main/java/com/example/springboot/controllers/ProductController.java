package com.example.springboot.controllers;

import com.example.springboot.dtos.ProductsRecordDto;
import com.example.springboot.models.ProductModels;
import com.example.springboot.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/apicrud")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public ResponseEntity<ProductModels> saveProduct(@RequestBody @Valid ProductsRecordDto productsRecordDto) {
        var productModels = new ProductModels();
        BeanUtils.copyProperties(productsRecordDto, productModels);
        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModels));
    }

    @GetMapping
    public ResponseEntity<List<ProductModels>> getAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value = "id") UUID id) {
        Optional<ProductModels> productO = productRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productO.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") UUID id, @RequestBody @Valid ProductsRecordDto productsRecordDto) {
        Optional<ProductModels> productO = productRepository.findById(id);
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
        var productModels = productO.get();
        BeanUtils.copyProperties(productsRecordDto, productModels, "id");
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModels));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value = "id") UUID id) {
        Optional<ProductModels> productO = productRepository.findById(id); // Corrigido
        if (productO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found."); // Corrigido
        }
        productRepository.delete(productO.get());
        return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully"); // Corrigido
    }
}
;