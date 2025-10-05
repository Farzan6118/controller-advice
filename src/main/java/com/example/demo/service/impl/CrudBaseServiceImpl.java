package com.example.demo.service.impl;

import com.example.demo.dto.mapper.BaseMapper;
import com.example.demo.dto.response.PageResponseDto;
import com.example.demo.service.CrudBaseService;
import com.example.demo.util.PageMapperUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@RequiredArgsConstructor
public class CrudBaseServiceImpl<E, ID, Q, S> implements CrudBaseService<Q, S, ID> {

    private final JpaRepository<E, ID> repository;
    private final BaseMapper<E, S, Q> mapper;

    @Override
    public S create(Q requestDto) {
        E entity = mapper.toEntity(requestDto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public S partiallyUpdate(Q requestDto, ID id) {
        E entity = repository.findById(id).orElseThrow();
        mapper.partialUpdateFromDto(requestDto, entity);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public S update(Q requestDto, ID id) {
        E entity = repository.findById(id).orElseThrow();
        mapper.updateFromDto(requestDto, entity);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public List<S> getAll() {
        return mapper.toDtos(repository.findAll());
    }

    @Override
    public PageResponseDto<S> getAllWithPagination(Pageable pageable) {
        return PageMapperUtil.toPageResponse(repository.findAll(pageable), mapper::toDto);
    }

    @Override
    public S getById(ID id) {
        return mapper.toDto(repository.findById(id).orElseThrow());
    }

    @Override
    public void deleteById(ID id) {
        repository.deleteById(id);
    }
}
