package com.learn.pagination_filtering.dtos.responses;

import java.time.LocalDateTime;

public record CategoryResponse(

        Long id,
        String categoryName,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        LocalDateTime deleteAt

) {
}