package com.example.demo.dto;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class AuthorDto {

    private Long id;

    private String nickName;

    private String nationality;

    private List<BookDto> books = new ArrayList<>();

//    private PassportDto passport;

    private List<PublisherDto> publishers = new ArrayList<>();

    private Long version;

}
