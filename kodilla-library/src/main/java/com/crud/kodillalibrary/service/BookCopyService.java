package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.BookCopy;
import com.crud.kodillalibrary.domain.BookCopyDto;
import com.crud.kodillalibrary.mapper.BookCopyMapper;
import com.crud.kodillalibrary.repository.BookCopyRepository;
import com.crud.kodillalibrary.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookCopyService {

    private final BookRepository bookRepository;
    private final BookCopyRepository bookCopyRepository;
    private final BookCopyMapper bookCopyMapper;

    public Optional<BookCopyDto> addBookCopy(BookCopyDto bookCopyDto) {
        Optional<Book> book = bookRepository.findById(bookCopyDto.getBookId());
        if(book.isPresent()) {
          BookCopy copy = bookCopyMapper.mapToBookCopy(bookCopyDto, book.get());
          copy = bookCopyRepository.save(copy);
          return Optional.of(bookCopyMapper.mapToBookCopyDto(copy));
        }
        return Optional.empty();
    }
}
