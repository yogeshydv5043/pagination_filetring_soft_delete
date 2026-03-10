package com.learn.pagination_filtering.dtos.responses;

import java.time.LocalDateTime;

public record ErrorMessage(String error_message,int error_code,String error_status, String path, LocalDateTime timestamp) {
}
