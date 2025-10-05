package com.example.demo.controller;

import com.example.demo.dto.request.EmployeeRequestDto;
import com.example.demo.dto.response.EmployeeResponseDto;
import com.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/employee")
public class EmployeeController extends CrudBaseController<EmployeeRequestDto, EmployeeResponseDto, Integer> {


    public EmployeeController(EmployeeService employeeService) {
        super(employeeService);
    }
}
