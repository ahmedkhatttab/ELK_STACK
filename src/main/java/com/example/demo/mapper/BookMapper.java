package com.example.demo.mapper;

import com.example.demo.dto.BookDto;
import com.example.demo.entity.Book;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface BookMapper extends GenericMapper<Book, BookDto>{

    @Mappings({
        @Mapping(target = "author", ignore = true)
    })
    @Override
    BookDto mapToDto(Book entity);

    @BeforeMapping
    default void updateToOneRelationship(@MappingTarget Book book){
        book.setAuthor(null);
    }


}
