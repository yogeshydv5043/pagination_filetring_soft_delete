package com.learn.pagination_filtering.utils.impl;

import com.learn.pagination_filtering.dtos.requests.CategoryRequest;
import com.learn.pagination_filtering.dtos.requests.ProductRequest;
import com.learn.pagination_filtering.dtos.responses.*;
import com.learn.pagination_filtering.models.Category;
import com.learn.pagination_filtering.models.Product;
import com.learn.pagination_filtering.utils.CategoryMapper;
import com.learn.pagination_filtering.utils.ProductMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapper implements ProductMapper, CategoryMapper {


    @Override
    public Category categoryRequestToCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setCategoryName(categoryRequest.categoryName());
        category.setDescription(categoryRequest.description());
        return category;
    }

    @Override
    public CategoryResponse categoryToCategoryResponse(Category category) {
        return new CategoryResponse(category.getId(),
                category.getCategoryName(),
                category.getDescription(),
                category.getCreateAt(),
                category.getUpdateAt(),
                category.getDeleteAt());
    }

    @Override
    public CategoryDTO categoryToCategoryDTO(Category category) {
        return new CategoryDTO(category.getId(),
                category.getCategoryName());
    }

    @Override
    public Product productRequestToProduct(ProductRequest productRequest) {
        Product products = new Product();
        products.setName(productRequest.name());
        products.setDescription(productRequest.description());
        products.setPrice(productRequest.price());
        products.setQuantity(productRequest.quantity());
        products.setBrand(productRequest.brand());
        return products;
    }

    @Override
    public ProductResponse productToProductResponse(Product products) {
        CategoryResponse categoryResponse = categoryToCategoryResponse(products.getCategory());
        return new ProductResponse(products.getId(),
                products.getName(),
                products.getDescription(),
                products.getPrice(),
                products.getQuantity(),
                products.getBrand(),
                categoryResponse,
                products.getCreateAt(),
                products.getUpdateAt());
    }

    @Override
    public ProductDTO productToProductDto(Product products) {
        CategoryDTO categoryResponse = categoryToCategoryDTO(products.getCategory());
        return new ProductDTO(products.getId(),
                products.getName(),
                products.getDescription(),
                products.getPrice(),
                products.getQuantity(),
                products.getBrand(),
                categoryResponse,
                products.getCreateAt());
    }

    @Override
    public ProductResponseV2 productToCategoryResponseV2(Product products) {
        CategoryDTO categoryResponse = categoryToCategoryDTO(products.getCategory());
        return new ProductResponseV2(products.getId(),
                products.getName(),
                products.getDescription(),
                products.getPrice(),
                products.getQuantity(),
                products.getBrand(),
                categoryResponse);
    }
}
