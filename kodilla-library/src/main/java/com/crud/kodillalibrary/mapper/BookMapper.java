package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.BookDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public Book mapToBook(BookDto bookDto) {
        return Book.builder()
                .id(bookDto.getId())
                .author(bookDto.getAuthor())
                .title(bookDto.getTitle())
                .yearOfPublication(bookDto.getYearOfPublication())
                .build();
    }

    public BookDto mapToBookDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .author(book.getAuthor())
                .title(book.getTitle())
                .yearOfPublication(book.getYearOfPublication())
                .build();
    }

    public List<BookDto> mapToBooksDto(List<Book> books) {
        return books.stream()
                .map(this::mapToBookDto)
                .collect(Collectors.toList());
    }

}
