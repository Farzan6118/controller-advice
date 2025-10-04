package com.example.demo.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public record PaginationRequestDto(
        @Min(value = 0, message = "${validation.page.number.min}")
        @Schema(defaultValue = "0")
        int page,

        @Min(value = 1, message = "${validation.page.size.min}")
        @Max(value = 100, message = "${validation.page.size.max}")
        @Schema(defaultValue = "10")
        int size,

        @Schema(defaultValue = "id")
        String sortBy,
        @Schema(defaultValue = "ASC")
        SortDirection sortDirection
) {

    public static PaginationRequestDto defaultRequest() {
        return new PaginationRequestDto(0, 20, "id", SortDirection.DESC);
    }

    public Pageable toPageable() {
        int pageNumber = Math.max(page, 0);
        int pageSize = Math.min(Math.max(size, 1), 100);

        String finalSortBy = (sortBy == null || sortBy.isBlank()) ? "id" : sortBy;
        Sort.Direction direction = (sortDirection == null) ? Sort.Direction.DESC
                : Sort.Direction.valueOf(sortDirection.name());


        return PageRequest.of(pageNumber, pageSize, Sort.by(direction, finalSortBy));
    }

    public enum SortDirection {
        ASC, DESC
    }
}
