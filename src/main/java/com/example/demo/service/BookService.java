package com.example.demo.service;


import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.repo.BookRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookService {

    private final BookRepo bookRepo;

    private final BookMapper bookMapper;

    @Transactional
    public BookDto createBook(BookDto bookDto){
        return
                bookMapper.mapToDto(
                        bookRepo.save(
                                bookMapper.mapToEntity(bookDto)
                        )
                );
    }


    public Book findById(Long id){
        return bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @Transactional
    public BookDto updateBook(BookDto bookDto){
        return
                bookMapper.mapToDto(
                        bookRepo.save(
                                bookMapper.mapToUpdate(
                                        findById(bookDto.getId()), bookDto
                                )
                        )
                );
    }
}
