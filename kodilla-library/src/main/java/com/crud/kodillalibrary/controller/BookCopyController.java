package com.crud.kodillalibrary.controller;

import com.crud.kodillalibrary.domain.BookCopyDto;
import com.crud.kodillalibrary.service.BookCopyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/books-copy")
public class BookCopyController {

    private final BookCopyService bookCopyService;

    @PostMapping
    public BookCopyDto addNewBookCopy(@RequestBody BookCopyDto bookCopyDto) {
        return bookCopyService.addBookCopy(bookCopyDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }

}
