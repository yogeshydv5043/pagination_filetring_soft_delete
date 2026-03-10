package com.learn.pagination_filtering.services.impl;


import com.learn.pagination_filtering.dtos.requests.ProductRequest;
import com.learn.pagination_filtering.dtos.responses.ProductDTO;
import com.learn.pagination_filtering.dtos.responses.ProductResponse;
import com.learn.pagination_filtering.dtos.responses.ProductResponseV2;
import com.learn.pagination_filtering.exceptions.ResourceNotFoundException;
import com.learn.pagination_filtering.models.Category;
import com.learn.pagination_filtering.models.Product;
import com.learn.pagination_filtering.repository.CategoryRepository;
import com.learn.pagination_filtering.repository.ProductRepository;
import com.learn.pagination_filtering.services.ProductService;
import com.learn.pagination_filtering.utils.impl.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productsRepository;
    private final CategoryRepository categoryRepository;
    private final Mapper mapper;


    @Transactional
    @Override
    public ProductDTO createProduct(ProductRequest request) {
        Category category = categoryRepository.findById(request.categoryId()).orElseThrow(() -> new ResourceNotFoundException(String.format("category not found in this Id : %d !!", request.categoryId())));

        Product products = mapper.productRequestToProduct(request);
        products.setCategory(category);
        Product saveProduct = productsRepository.save(products);
        return mapper.productToProductDto(saveProduct);
    }

    @Transactional(readOnly = true)
    @Override
    public ProductResponse getProduct(Long id) {
        Product product = productsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("category not found in this Id : %d !!", id)));
        return mapper.productToProductResponse(product);
    }

    @Transactional(readOnly = true)
    @Override
    public List<ProductResponseV2> getAllProducts() {
        return List.of();
    }

    @Transactional
    @Override
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = productsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product not found with Id: %d !!", id)));

        Category category = categoryRepository.findById(request.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Category not found with Id: %d !!", request.categoryId())));

        // Create new product from request
        Product newProduct = mapper.productRequestToProduct(request);
        newProduct.setCategory(category);

        // Copy new data to existing product (correct order: source -> target)
        BeanUtils.copyProperties(newProduct, product);

        Product updated = productsRepository.save(product);
        return mapper.productToProductResponse(updated);
    }

    @Transactional
    @Override
    public void deleteProduct(Long id) {
        Product product = productsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product not found with Id: %d !!", id)));
        product.setDeletedAt(LocalDateTime.now());
        product.setDeleted(true);
        productsRepository.save(product);
    }
}
