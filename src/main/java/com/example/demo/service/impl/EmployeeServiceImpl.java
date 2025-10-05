package com.example.demo.service.impl;

import com.example.demo.dto.mapper.EmployeeMapper;
import com.example.demo.dto.request.EmployeeRequestDto;
import com.example.demo.dto.response.EmployeeResponseDto;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends
        CrudBaseServiceImpl<Employee, Integer, EmployeeRequestDto, EmployeeResponseDto>
        implements EmployeeService {

    public EmployeeServiceImpl(EmployeeRepository repository,
                               EmployeeMapper mapper) {
        super(repository, mapper);
    }
}
