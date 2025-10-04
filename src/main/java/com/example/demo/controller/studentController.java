package com.example.demo.controller;

import com.example.demo.dto.request.PaginationRequestDto;
import com.example.demo.dto.request.StudentRequestDto;
import com.example.demo.dto.response.PageResponseDto;
import com.example.demo.dto.response.StudentResponseDto;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class studentController {

    private final StudentService studentService;


    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(
            @RequestBody @Valid StudentRequestDto requestDto) {
        return ResponseEntity.ok(studentService.create(requestDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentResponseDto> updatePartiallyStudent(
            @RequestBody @Valid StudentRequestDto requestDto,
            @PathVariable @NotNull(message = "PathVariable id must not be null")
            @Positive(message = "PathVariable id must be positive") Integer id) {
        return ResponseEntity.ok(studentService.partiallyUpdate(requestDto, id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(
            @RequestBody @Valid StudentRequestDto requestDto,
            @PathVariable @NotNull(message = "PathVariable id must not be null")
            @Positive(message = "PathVariable id must be positive") Integer id) {
        return ResponseEntity.ok(studentService.update(requestDto, id));
    }

    @GetMapping
    public ResponseEntity<List<StudentResponseDto>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/paged")
    public ResponseEntity<PageResponseDto<StudentResponseDto>> getAllStudentsWithPage(
            @Valid PaginationRequestDto paginationRequestDto) {
        return ResponseEntity.ok(studentService.getAllWithPagination(paginationRequestDto.toPageable()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDto> getStudent(
            @PathVariable @NotNull(message = "PathVariable id must not be null")
            @Positive(message = "PathVariable id must be positive") Integer id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentById(
            @PathVariable @NotNull(message = "PathVariable id must not be null")
            @Positive(message = "PathVariable id must be positive") Integer id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
