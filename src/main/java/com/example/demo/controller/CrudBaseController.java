package com.example.demo.controller;

import com.example.demo.dto.request.PaginationRequestDto;
import com.example.demo.dto.response.PageResponseDto;
import com.example.demo.service.CrudBaseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public class CrudBaseController<REQ, RES, ID> {

    protected final CrudBaseService<REQ, RES, ID> service;

    @PostMapping
    public ResponseEntity<RES> create(@RequestBody @Valid REQ requestDto) {
        return ResponseEntity.ok(service.create(requestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RES> partiallyUpdate(
            @RequestBody @Valid REQ requestDto,
            @PathVariable @NotNull(message = "PathVariable id must not be null")
            @Positive(message = "PathVariable id must be positive") ID id) {
        return ResponseEntity.ok(service.partiallyUpdate(requestDto, id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RES> update(
            @RequestBody @Valid REQ requestDto,
            @PathVariable @NotNull(message = "PathVariable id must not be null")
            @Positive(message = "PathVariable id must be positive") ID id) {
        return ResponseEntity.ok(service.update(requestDto, id));
    }

    @GetMapping
    public ResponseEntity<List<RES>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/paged")
    public ResponseEntity<PageResponseDto<RES>> getAllWithPage(
            @Valid PaginationRequestDto paginationRequestDto) {
        return ResponseEntity.ok(service.getAllWithPagination(paginationRequestDto.toPageable()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RES> getById(
            @PathVariable @NotNull(message = "PathVariable id must not be null")
            @Positive(message = "PathVariable id must be positive") ID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable @NotNull(message = "PathVariable id must not be null")
            @Positive(message = "PathVariable id must be positive") ID id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
