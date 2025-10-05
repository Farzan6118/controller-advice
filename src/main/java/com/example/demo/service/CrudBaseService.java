package com.example.demo.service;

import com.example.demo.dto.response.PageResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CrudBaseService<REQ, RES, ID> {
    RES create(REQ requestDto);

    RES partiallyUpdate(REQ requestDto, ID id);

    RES update(REQ requestDto, ID id);

    List<RES> getAll();

    PageResponseDto<RES> getAllWithPagination(Pageable pageable);

    RES getById(ID id);

    void deleteById(ID id);
}