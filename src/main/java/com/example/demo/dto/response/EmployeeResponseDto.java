package com.example.demo.dto.response;

import com.example.demo.enums.Gender;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public record EmployeeResponseDto(
        String firstName,
        String lastName,
        String email,
        String mobile,
        String nationalCode,
        @Enumerated(EnumType.STRING)
        Gender gender,
        LocalDate birthDate,
        String nationality,
        LocalDate entryYear
) {
}