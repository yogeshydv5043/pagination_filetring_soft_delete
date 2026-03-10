package com.learn.pagination_filtering.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(

        @NotBlank(message = "Category name is required")
        @Size(min = 3, max = 50)
        String categoryName,

        @Size(max = 200)
        String description

) {}