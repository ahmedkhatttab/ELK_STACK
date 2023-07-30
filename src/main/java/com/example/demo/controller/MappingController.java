package com.example.demo.controller;

import com.example.demo.dto.AuthorDto;
import com.example.demo.dto.BookDto;
import com.example.demo.dto.PublisherDto;
import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.PublisherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class MappingController {

    private final AuthorService authorService;

    private final PublisherService publisherService;

    private final BookService bookService;

    @PostMapping("/authors")
    public ResponseEntity<AuthorDto> createAuthorAndBooks(@RequestBody @Valid AuthorDto author){
        return ResponseEntity.ok(authorService.createAuthor(author));
    }


    @PutMapping("/authors")
    public ResponseEntity<AuthorDto> updateAuthorAndBooks(@RequestBody @Valid AuthorDto author){
        return ResponseEntity.ok(authorService.updateAuthor(author));
    }



    @GetMapping("/authors/{id}")
    public ResponseEntity<AuthorDto> getAuthorInfo(@PathVariable Long id){
        return ResponseEntity.ok(authorService.getAuthorInfo(id));
    }



    @PostMapping("/books")
    public ResponseEntity<BookDto> createBook(@RequestBody @Valid BookDto book){
        return ResponseEntity.ok(bookService.createBook(book));
    }


    @PutMapping("/books")
    public ResponseEntity<BookDto> updateBook(@RequestBody @Valid BookDto book){
        return ResponseEntity.ok(bookService.updateBook(book));
    }



    @GetMapping("/publishers/{id}")
    public ResponseEntity<PublisherDto> getPublisherInfo(@PathVariable Long id){
        return ResponseEntity.ok(publisherService.getPublisherInfo(id));
    }

}
