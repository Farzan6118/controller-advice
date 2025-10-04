package com.example.demo.service;

import com.example.demo.dto.request.StudentRequestDto;
import com.example.demo.dto.response.PageResponseDto;
import com.example.demo.dto.response.StudentResponseDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentService {
    StudentResponseDto create(StudentRequestDto requestDto);

    StudentResponseDto partiallyUpdate(StudentRequestDto requestDto, Integer id);

    StudentResponseDto update(StudentRequestDto requestDto, Integer id);

    List<StudentResponseDto> getAll();

    PageResponseDto<StudentResponseDto> getAllWithPagination(Pageable pageable);

    StudentResponseDto getById(Integer id);

    void deleteById(Integer id);
}
