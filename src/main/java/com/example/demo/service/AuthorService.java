package com.example.demo.service;


import com.example.demo.dto.AuthorDto;
import com.example.demo.entity.Author;
import com.example.demo.mapper.AuthorMapper;
import com.example.demo.repo.AuthorRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OptimisticLockException;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorService {

    private static int counter = 1;

    private final AuthorRepo authorRepo;

    private final AuthorMapper authorMapper;

    @Transactional
    public AuthorDto createAuthor(AuthorDto authorDto){
        return
            authorMapper.mapToDto(
                    authorRepo.save(
                            authorMapper.mapToEntity(authorDto)
                    )
            );
    }


    public Author findById(Long id){
        return authorRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public Author getAuthor(Long id){
        return authorRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }


    public AuthorDto getAuthorInfo(Long id){
        Author author = authorRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));

        return authorMapper.mapToDto(author);
    }


    @Transactional
    public AuthorDto updateAuthor(AuthorDto authorDto){

        Author author = findById(authorDto.getId());

        if(author.getVersion()!= authorDto.getVersion()){
            throw new OptimisticLockException("The author has been updated by another user");
        }

        authorDto.setNickName((counter ++)+" - " +authorDto.getNickName());
        return
            authorMapper.mapToDto(
                    authorRepo.save(
                            authorMapper.mapToUpdate(
                                    author, authorDto
                            )
                    )
            );
    }

}
