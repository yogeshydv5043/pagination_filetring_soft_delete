package com.learn.pagination_filtering.services.impl;

import com.learn.pagination_filtering.dtos.requests.CategoryRequest;
import com.learn.pagination_filtering.dtos.responses.CategoryResponse;
import com.learn.pagination_filtering.exceptions.ResourceAlreadyExistsException;
import com.learn.pagination_filtering.exceptions.ResourceNotFoundException;
import com.learn.pagination_filtering.models.Category;
import com.learn.pagination_filtering.repository.CategoryRepository;
import com.learn.pagination_filtering.services.CategoryService;
import com.learn.pagination_filtering.utils.impl.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final Mapper mapper;

    @Transactional
    @Override
    public CategoryResponse createCategory(CategoryRequest request) {

        if (categoryRepository.existsByCategoryNameIgnoreCase(request.categoryName())) {
            throw new ResourceAlreadyExistsException(
                    String.format("Category already exists with name: %s", request.categoryName())
            );
        }
        Category category = new Category();
        category.setCategoryName(request.categoryName());
        category.setDescription(request.description());

        Category savedCategory = categoryRepository.save(category);

        return mapper.categoryToCategoryResponse(savedCategory);
    }


    @Transactional(readOnly = true)
    @Override
    public List<CategoryResponse> getAllCategories() {
        List<Category> categories=categoryRepository.findAll();
        return categories.stream().map(mapper::categoryToCategoryResponse).toList();
    }

    @Transactional(readOnly = true)
    @Override
    public CategoryResponse getCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Category not found with id: %d", id)));
        return mapper.categoryToCategoryResponse(category);
    }

    @Transactional
    @Override
    public CategoryResponse updateCategory(Long id, CategoryRequest request) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Category not found with id: %d", id)));

        if(categoryRepository.existsByCategoryNameIgnoreCase(request.categoryName())
                && !category.getCategoryName().equalsIgnoreCase(request.categoryName())) {
            throw new ResourceAlreadyExistsException(
                    String.format("Category already exists with name: %s", request.categoryName())
            );
        }

        category.setCategoryName(request.categoryName());
        category.setDescription(request.description());
        Category updatedCategory = categoryRepository.save(category);
        return mapper.categoryToCategoryResponse(updatedCategory);
    }

    @Transactional
    @Override
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(String.format("Category not found with id: %d", id)));
        category.setDeleteAt(LocalDateTime.now());
        category.setDeleteFlag(true);
        categoryRepository.save(category);
    }
}
