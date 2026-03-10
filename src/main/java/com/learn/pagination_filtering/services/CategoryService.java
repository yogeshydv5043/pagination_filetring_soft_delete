package com.learn.pagination_filtering.services;

import com.learn.pagination_filtering.dtos.requests.CategoryRequest;
import com.learn.pagination_filtering.dtos.responses.CategoryResponse;

import java.util.List;


public interface CategoryService {

    CategoryResponse createCategory(CategoryRequest request);

    List<CategoryResponse> getAllCategories();

    CategoryResponse getCategory(Long id);

    CategoryResponse updateCategory(Long id, CategoryRequest request);

    void deleteCategory(Long id);
}