package com.learn.pagination_filtering.dtos.responses;

import java.time.LocalDateTime;

public record ProductDTO(Long id,
                         String name,
                         String description,
                         double price,
                         int quantity,
                         String brand,
                         CategoryDTO category,
                         LocalDateTime createAt) {
}
