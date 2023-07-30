package com.example.demo.mapper;

import com.example.demo.dto.PassportDto;
import com.example.demo.entity.Passport;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PassportMapper extends GenericMapper<Passport, PassportDto>{


}
