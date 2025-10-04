package com.example.demo.advice;

import java.util.Map;

public record ErrorResponse(
        String code,
        String message,
        Map<String, String> details
) {
}
