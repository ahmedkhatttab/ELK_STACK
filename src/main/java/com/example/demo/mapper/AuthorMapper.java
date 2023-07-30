package com.example.demo.mapper;


import com.example.demo.dto.AuthorDto;
import com.example.demo.entity.Author;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring"
        , uses = {BookMapper.class, PassportMapper.class, PublisherMapper.class}
)
public interface AuthorMapper extends GenericMapper<Author, AuthorDto>{


    @AfterMapping
    default void setOneToManyRelationship(@MappingTarget Author author){
        author.getBooks().forEach(b-> b.setAuthor(author));
    }

//    @BeforeMapping
//    default void updateOneToOneRelationship(@MappingTarget Author author){
//       author.setPassport(null);
//    }

}
