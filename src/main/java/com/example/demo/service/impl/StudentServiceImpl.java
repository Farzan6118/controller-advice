package com.example.demo.service.impl;

import com.example.demo.dto.mapper.StudentMapper;
import com.example.demo.dto.request.StudentRequestDto;
import com.example.demo.dto.response.PageResponseDto;
import com.example.demo.dto.response.StudentResponseDto;
import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import com.example.demo.util.PageMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public StudentResponseDto create(StudentRequestDto requestDto) {
        Student entity = studentMapper.toEntity(requestDto);
        return studentMapper.toDto(studentRepository.save(entity));
    }

    @Override
    public StudentResponseDto partiallyUpdate(StudentRequestDto requestDto, Integer id) {
        Student entity = studentRepository.findById(id).orElseThrow();
        studentMapper.partialUpdateFromDto(requestDto, entity);
        return studentMapper.toDto(studentRepository.save(entity));
    }

    @Override
    public StudentResponseDto update(StudentRequestDto requestDto, Integer id) {
        Student entity = studentRepository.findById(id).orElseThrow();
        studentMapper.updateFromDto(requestDto, entity);
        return studentMapper.toDto(studentRepository.save(entity));
    }

    @Override
    public List<StudentResponseDto> getAll() {
        return studentMapper.toDtos(studentRepository.findAll());
    }

    @Override
    public PageResponseDto<StudentResponseDto> getAllWithPagination(Pageable pageable) {
        return PageMapperUtil.toPageResponse(studentRepository.findAll(pageable), studentMapper::toDto);
    }

    @Override
    public StudentResponseDto getById(Integer id) {
        return studentMapper.toDto(studentRepository.findById(id).orElseThrow());
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

}
