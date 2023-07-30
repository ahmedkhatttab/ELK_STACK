package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface GenericMapper<E, D> {

    E mapToEntity(D dto);

    D mapToDto(E entity);


    E mapToUpdate(@MappingTarget E entity, D source);

    List<E> mapToEntity(List<D> dto);

    List<D> mapToDto(List<E> entity);

}
