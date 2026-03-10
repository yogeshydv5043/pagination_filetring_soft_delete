package com.learn.pagination_filtering.dtos.responses;

public record ProductResponseV2(
        Long id,
        String name,
        String description,
        double price,
        int quantity,
        String brand,
        CategoryDTO category

) {
}
