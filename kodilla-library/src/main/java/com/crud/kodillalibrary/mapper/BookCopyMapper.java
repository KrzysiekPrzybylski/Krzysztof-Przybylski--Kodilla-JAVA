package com.crud.kodillalibrary.mapper;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.BookCopy;
import com.crud.kodillalibrary.domain.BookCopyDto;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BookCopyMapper {

    public BookCopy mapToBookCopy(BookCopyDto bookCopyDto, Book book){
        return BookCopy.builder()
                .isBorrowed(bookCopyDto.isBorrowed())
                .book(book)
                .build();
    }

    public BookCopyDto mapToBookCopyDto(BookCopy copy) {
        return BookCopyDto.builder()
                .bookCopyId(copy.getId())
                .bookId(copy.getBook().getId())
                .borrowed(copy.isBorrowed())
                .build();
    }
}
