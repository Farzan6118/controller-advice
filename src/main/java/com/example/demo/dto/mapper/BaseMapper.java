package com.example.demo.dto.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;
import java.util.Set;

public interface BaseMapper<E, S, Q> {
    /**
     * Map single entity → DTO
     */
    S toDto(E entity);

    /**
     * Map single DTO → entity
     */
    E toEntity(Q dto);

    /**
     * Map list of entities → list of DTOs
     */
    List<S> toDtos(List<E> entities);

    Set<S> toDtos(Set<E> entities);


    /**
     * Map list of DTOs → list of entities
     */
    List<E> toEntities(List<Q> dtos);

    List<E> toEntities(Set<Q> dtos);


//    /**
//     * Map Page of entities → Page of DTOs
//     */
//    default Page<D> toDtoPage(Page<E> page) {
//        if (page == null) return null;
//        List<D> dtos = toDtos(page.getContent());
//        return new PageImpl<>(dtos, page.getPageable(), page.getTotalElements());
//    }

    /**
     * Patch / partial update
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdateFromDto(Q dto, @MappingTarget E entity);

    /**
     * update
     */
    void updateFromDto(Q dto, @MappingTarget E entity);


}
