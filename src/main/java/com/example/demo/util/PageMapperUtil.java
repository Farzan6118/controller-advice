package com.example.demo.util;

import com.example.demo.dto.response.PageResponseDto;
import org.springframework.data.domain.Page;

import java.util.function.Function;

public class PageMapperUtil {

    public static <T, R> PageResponseDto<R> toPageResponse(Page<T> page, Function<T, R> mapper) {
        return PageResponseDto.<R>builder()
                .content(page.map(mapper).getContent())
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .first(page.isFirst())
                .last(page.isLast())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .size(page.getNumberOfElements())
                .build();
    }

    public static <T> PageResponseDto<T> toPageResponse(Page<T> page) {
        return PageResponseDto.<T>builder()
                .content(page.getContent())
                .pageNumber(page.getNumber())
                .pageSize(page.getSize())
                .first(page.isFirst())
                .last(page.isLast())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .size(page.getNumberOfElements())
                .build();
    }
}
