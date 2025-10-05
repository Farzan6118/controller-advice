package com.example.demo.service;

import com.example.demo.dto.request.EmployeeRequestDto;
import com.example.demo.dto.response.EmployeeResponseDto;

public interface EmployeeService extends CrudBaseService<EmployeeRequestDto, EmployeeResponseDto,
        Integer> {
}
