package com.example.demo.dto.mapper;

import com.example.demo.dto.request.StudentRequestDto;
import com.example.demo.dto.response.StudentResponseDto;
import com.example.demo.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper extends BaseMapper<Student, StudentResponseDto, StudentRequestDto> {
}
