package com.example.demo.dto.request;

import com.example.demo.enums.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Schema(name = "EmployeeRequest", description = "DTO for creating or updating a Employee")
public record EmployeeRequestDto(

        @NotBlank(message = "{student.firstName.notBlank}")
        @Schema(description = "First name of the student", example = "John")
        String firstName,

        @NotBlank(message = "{student.lastName.notBlank}")
        @Schema(description = "Last name of the student", example = "Doe")
        String lastName,

        @NotBlank(message = "{student.email.notBlank}")
        @Email(message = "{student.email.invalid}")
        @Schema(description = "Email of the student", example = "john.doe@example.com")
        String email,

        @NotBlank(message = "{student.mobile.notBlank}")
        @Pattern(regexp = "\\d{10,15}", message = "{student.mobile.invalid}")
        @Schema(description = "Mobile number (10-15 digits)", example = "09123456789")
        String mobile,

        @NotBlank(message = "{student.nationalCode.notBlank}")
        @Pattern(regexp = "\\d{10}", message = "{student.nationalCode.invalid}")
        @Schema(description = "National code (10 digits)", example = "0012345678")
        String nationalCode,

        @NotNull(message = "{student.gender.notNull}")
        @Schema(description = "Gender of the student", example = "MALE",
                allowableValues = {"UNSPECIFIED", "FEMALE", "MALE", "OTHER"})
        @Enumerated(EnumType.STRING)
        Gender gender,

        @NotNull(message = "{student.birthDate.notNull}")
        @Past(message = "{student.birthDate.past}")
        @Schema(description = "Birth date of the student", example = "2000-05-20")
        LocalDate birthDate,

        @NotBlank(message = "{student.nationality.notBlank}")
        @Schema(description = "Nationality of the student", example = "Iran")
        String nationality,

        @NotNull(message = "{student.entryYear.notNull}")
        @Schema(description = "Year of entry", example = "2024-05-20")
        LocalDate entryYear
) {
}