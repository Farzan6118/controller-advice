package com.example.demo.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class PageResponseDto<T> {
    private List<T> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Boolean first;
    private Boolean last;
    private Long totalElements;
    private Integer totalPages;
    private Integer size;
}
