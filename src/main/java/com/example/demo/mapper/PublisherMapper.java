package com.example.demo.mapper;

import com.example.demo.dto.PublisherDto;
import com.example.demo.entity.Publisher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PublisherMapper extends GenericMapper<Publisher, PublisherDto>{

    @Mappings({
            @Mapping(target = "authors", ignore = true)
    })
    @Override
    PublisherDto mapToDto(Publisher entity);
}
