package com.example.demo.service;


import com.example.demo.dto.AuthorDto;
import com.example.demo.dto.PublisherDto;
import com.example.demo.entity.Author;
import com.example.demo.entity.Publisher;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.mapper.PublisherMapper;
import com.example.demo.repo.AuthorRepo;
import com.example.demo.repo.PublisherRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepo publisherRepo;

    private final PublisherMapper publisherMapper;


    public PublisherDto getPublisherInfo(Long id){
        Publisher publisher = publisherRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));

        return publisherMapper.mapToDto(publisher);
    }



}
