package com.learn.pagination_filtering.controller;

import com.learn.pagination_filtering.dtos.requests.ProductRequest;
import com.learn.pagination_filtering.dtos.responses.ProductDTO;
import com.learn.pagination_filtering.dtos.responses.ProductResponse;
import com.learn.pagination_filtering.dtos.responses.ProductResponseV2;
import com.learn.pagination_filtering.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductRequest productRequest) {
        ProductDTO productResponse = productService.createProduct(productRequest);
        return ResponseEntity.ok(productResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProductByID(@PathVariable Long id) {
        ProductResponse productResponse = productService.getProduct(id);
        return ResponseEntity.ok(productResponse);
    }


    @GetMapping
    public ResponseEntity<List<ProductResponseV2>> getAllCategories() {
        return ResponseEntity.ok(productService.getAllProducts());
    }


    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateCategory(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequest request) {

        return ResponseEntity.ok(productService.updateProduct(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {

        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
