package com.learn.pagination_filtering.dtos.responses;

import java.time.LocalDateTime;

public record ProductResponse(

        Long id,
        String name,
        String description,
        double price,
        int quantity,
        String brand,

       CategoryResponse category,

        LocalDateTime addingAt,
        LocalDateTime updateAt

) {

}