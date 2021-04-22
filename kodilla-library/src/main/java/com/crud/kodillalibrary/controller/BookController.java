package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.Book;
import com.crud.kodillalibrary.domain.BookDto;
import com.crud.kodillalibrary.service.BookService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/books")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<BookDto> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookDto getBook(@PathVariable Long id){
        return bookService.getBook(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @PostMapping
    public BookDto addBook(@RequestBody BookDto bookDto){
        return bookService.saveBook(bookDto);
    }
    @PutMapping
    public BookDto updateBook(@RequestBody BookDto bookDto){
        return bookService.updateBook(bookDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }
}
