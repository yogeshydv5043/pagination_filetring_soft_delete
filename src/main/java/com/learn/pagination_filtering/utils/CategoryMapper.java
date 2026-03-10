package com.learn.pagination_filtering.utils;

import com.learn.pagination_filtering.dtos.requests.CategoryRequest;
import com.learn.pagination_filtering.dtos.responses.CategoryDTO;
import com.learn.pagination_filtering.dtos.responses.CategoryResponse;
import com.learn.pagination_filtering.models.Category;

public interface CategoryMapper {

    public Category categoryRequestToCategory(CategoryRequest categoryRequest);

    public CategoryResponse categoryToCategoryResponse(Category category);

    public CategoryDTO categoryToCategoryDTO(Category category);

}
