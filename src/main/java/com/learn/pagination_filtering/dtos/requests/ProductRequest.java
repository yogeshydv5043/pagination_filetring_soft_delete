package com.learn.pagination_filtering.dtos.requests;

import jakarta.validation.constraints.*;

public record ProductRequest(

        @NotBlank(message = "Product name is required")
        @Size(min = 3, max = 100)
        String name,

        @NotBlank(message = "Description cannot be empty")
        String description,

        @Positive(message = "Price must be greater than 0")
        double price,

        @Min(value = 0, message = "Quantity cannot be negative")
        int quantity,

        @NotBlank(message = "Brand is required")
        String brand,

        @NotNull(message = "Category is required")
        Long categoryId

) {}