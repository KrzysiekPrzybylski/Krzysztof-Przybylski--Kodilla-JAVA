package com.crud.kodillalibrary.service;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.BookDto;
import com.crud.kodillalibrary.mapper.BookMapper;
import com.crud.kodillalibrary.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;


    public BookDto saveBook(BookDto bookDto){
        Book book = bookMapper.mapToBook(bookDto);
        book = bookRepository.save(book);
        return bookMapper.mapToBookDto(book);
    }
    public List<BookDto> getAllBooks(){
        List<Book> books = bookRepository.findAll();
        return bookMapper.mapToBooksDto(books);
    }
    public Optional<BookDto> getBook(Long id){
        Optional<Book> book = bookRepository.findById(id);
        return book.map(bookMapper::mapToBookDto);
    }
    public Optional<BookDto> updateBook(BookDto bookDto){
        Optional<Book> book = bookRepository.findById(bookDto.getId());
        if(book.isPresent()) {
            Book bookToUpdate = bookMapper.mapToBook(bookDto);
            bookToUpdate = bookRepository.save(bookToUpdate);
            return Optional.of(bookMapper.mapToBookDto(bookToUpdate));
        }
        return Optional.empty();
    }
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
